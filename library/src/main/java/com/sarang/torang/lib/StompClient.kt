package com.sarang.torang.lib

import android.util.Log
import com.gmail.bishoybasily.stomp.lib.Event
import com.gmail.bishoybasily.stomp.lib.Message
import com.sarang.torang.lib.constants.Codes
import com.sarang.torang.lib.constants.Commands
import com.sarang.torang.lib.constants.Headers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.*
import okio.ByteString
import java.io.StringReader
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.collections.HashMap

class StompClient(
    private val url: String,
    private val okHttpClient: OkHttpClient = OkHttpClient(),
    private val reconnectAfter: Long = 1000L,
) : WebSocketListener() {

    private val logger = Logger.getLogger(javaClass.name)

    private val DEFAULT_ACK = "auto"
    private val SUPPORTED_VERSIONS = "1.1,1.2"

    private val topics = HashMap<String, String>()

    private var shouldBeConnected: Boolean = false
    private var connected = false

    private lateinit var webSocket: WebSocket
    var connectionEvents: MutableSharedFlow<Message> = MutableSharedFlow()

    fun connect() {
        if (!connected) {
            shouldBeConnected = true
            open()
        } else {
            throw Exception("Already connected")
        }
    }

    fun disconnect() {
        if (connected) {
            shouldBeConnected = false
            close()
        } else {
            throw Exception("Already disconnected")
        }
    }


    fun join(topic: String) {

        if (topics.containsKey(topic)) {
            throw Exception("이미 채팅방에 접속중 입니다.")
        }

        val topicId = UUID.randomUUID().toString()
        val headers = HashMap<String, String>().apply {
            put(Headers.ID, topicId)
            put(Headers.DESTINATION, topic)
            put(Headers.ACK, DEFAULT_ACK)
        }
        topics[topic] = topicId

        if (webSocket.send(compileMessage(Message(Commands.SUBSCRIBE, headers)))) {
            onMessage(
                webSocket,
                compileMessage(Message(Commands.SUBSCRIBE, HashMap<String, String>().apply {
                    put("topic", topic)
                }))
            )
        }
    }

    fun unSubScribe(topic: String) {
        val topicId = topics[topic]
        val headers = HashMap<String, String>().apply {
            put(Headers.ID, topicId!!)
        }

        if (webSocket.send(compileMessage(Message(Commands.UNSUBSCRIBE, headers)))) {
            onMessage(
                webSocket,
                compileMessage(
                    Message(
                        Commands.UNSUBSCRIBE,
                        HashMap<String, String>().apply {
                            put("topic", topic)
                            put("topicId", topicId.toString())
                        })
                )
            )
        }
        topics.remove(topic)
    }

    fun send(token: String, uuid: String, topic: String, msg: String): Boolean {
        val headers = HashMap<String, String>().apply {
            put(Headers.DESTINATION, topic)
            put("TOKEN", token)
            put("UUID", uuid)
        }

        val result = webSocket.send(compileMessage(Message(Commands.SEND, headers, msg)))

        if (result) {
            onMessage(webSocket, compileMessage(Message(Commands.SEND, headers, msg)))
        }

        return result
    }

    fun send(topic: String, msg: String): Boolean {
        val headers = HashMap<String, String>().apply {
            put(Headers.DESTINATION, topic)
        }
        return webSocket.send(compileMessage(Message(Commands.SEND, headers, msg)))
    }

    private var coroutineScope: CoroutineScope? = null

    fun subScribeEvent(coroutineScope: CoroutineScope) {
        this.coroutineScope = coroutineScope
    }


    private fun open() {
        if (!connected) {
            logger.log(Level.INFO, "Connecting...")
            val request = Request.Builder()
                .url(url)
                .build()
            webSocket = okHttpClient.newWebSocket(request, this)
            connected = true
        } else {
            logger.log(Level.INFO, "Already connected")
        }
    }

    private fun reconnect() {
        if (shouldBeConnected) {
            close()
            Thread.sleep(reconnectAfter)
            open()
        }
    }

    private fun close() {
        if (connected) {
            logger.log(Level.INFO, "Disconnecting...")
            webSocket.close(Codes.DEFAULT, "")
            connected = false
        } else {
            logger.log(Level.INFO, "Already disconnected")
        }
    }

    private fun parseMessage(data: String?): Message {
        if (data.isNullOrBlank())
            return Message(Commands.UNKNOWN)

        val reader = Scanner(StringReader(data))
        reader.useDelimiter("\\n")
        val command = reader.next()
        val headers = HashMap<String, String>()

        while (reader.hasNext(Message.PATTERN_HEADER)) {
            val matcher = Message.PATTERN_HEADER.matcher(reader.next())
            matcher.find()
            headers[matcher.group(1)] = matcher.group(2)
        }

        reader.skip("\\s")
        reader.useDelimiter(Message.TERMINATE_MESSAGE_SYMBOL)
        val payload = if (reader.hasNext()) reader.next() else null

        return Message(command, headers, payload!!)
    }

    private fun compileMessage(message: Message): String {
        val builder = StringBuilder()

        message.command?.let {
            builder.append(it).append('\n')
        }

        message.headers.forEach { (key, value) ->
            builder.append(key).append(':').append(value).append('\n')
        }
        builder.append('\n')

        message.payload?.let {
            builder.append(it)
                //.append("\n\n")
        }

        builder.append(Message.TERMINATE_MESSAGE_SYMBOL)
        return builder.toString()
    }

// WebSocketListener override methods

    override fun onOpen(socket: WebSocket, response: Response) {
        val headers = HashMap<String, String>().apply {
            put(Headers.VERSION, SUPPORTED_VERSIONS)
        }
        webSocket.send(compileMessage(Message(Commands.CONNECT, headers)))
        logger.log(Level.INFO, "onOpen")
    }

    override fun onClosed(socket: WebSocket, code: Int, reason: String) {
        logger.log(Level.INFO, "onClosed reason: $reason, code: $code")
        reconnect()
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        handleMessage(parseMessage(bytes.toString()))
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        handleMessage(parseMessage(text))
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        if (webSocket.close(code, reason)) {
            onMessage(webSocket, compileMessage(Message(Commands.CLOSED)))
        }
        logger.log(Level.INFO, "onClosing reason: $reason, code: $code")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        logger.log(Level.INFO, "onFailure", t)
        //connectionEvents.tryEmit(Event(Event.Type.ERROR, t))
        reconnect()
    }

    private fun handleMessage(message: Message) {
        Log.d("__StompClient1", "handleMessage: ${message.command}, ${message.headers}")
        coroutineScope?.let {
            it.launch {
                connectionEvents.emit(message)
            }
        }
    }
}