package com.sarang.torang.util

import com.gmail.bishoybasily.stomp.lib.Message
import com.sarang.torang.lib.StompClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class WebSocketClient {
    /**
     * val url = "ws://sarang628.iptime.org:8081/chat/websocket"
     * val url = "ws://110.0.148.193:8081/chat/websocket"
     */
    val url = "ws://sarang628.iptime.org:8081/chat/websocket"
    private var stomp: StompClient = StompClient(url)

    fun getFlow(): Flow<Message> {
        return stomp.connectionEvents
    }


    fun sendMessage(token: String, uuid: String, roomId: Int, message: String) {
        stomp.send(token, uuid, "/app/$roomId", message)
    }

    fun subScribe(roomId: Int) {
        stomp.join("/topic/$roomId")
    }

    fun disconnect() {
        stomp.disconnect()
    }

    fun connect() {
        stomp.connect()
    }

    fun subScribeEvent(coroutineScope: CoroutineScope) {
        stomp.subScribeEvent(coroutineScope)
    }

    fun unSubscribe(roomId: Int) {
        stomp.unSubScribe("/topic/$roomId")
    }

}