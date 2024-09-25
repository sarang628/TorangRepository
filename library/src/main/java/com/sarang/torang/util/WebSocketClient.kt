package com.sarang.torang.util

import android.util.Log
import com.gmail.bishoybasily.stomp.lib.Event
import com.sarang.torang.lib.StompClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import okhttp3.OkHttpClient
import okhttp3.WebSocketListener

class WebSocketClient(webSocketListener: WebSocketListener) {
    /**
     * //        val url = "ws://sarang628.iptime.org:8081/chat/websocket"
     *         val url = ""
     * //        val url = "ws://110.0.148.193:8081/chat/websocket"
     * val intervalMillis = 1000L
     *         val client = OkHttpClient()
     */
    private var stomp: StompClient =
        StompClient(
            //"ws://192.168.0.14:8081/chat/websocket",
            "ws://sarang628.iptime.org:8081/chat/websocket",
            OkHttpClient(),
            1000L,
            webSocketListener
        )


    suspend fun sendMessage(token: String, uuid: String, roomId: Int, message: String) {
        Log.d(
            "__WebSocketClient",
            "message sent ${stomp.send(token, uuid, "/app/$roomId", message)}"
        )
    }

    fun subScribe(roomId: Int): Flow<String> {
        // 새로운 구독 시작
        try {
            return stomp.join("/topic/$roomId")
        } catch (e: Exception) {
            Log.e("__WebSocketClient", "Error collecting messages", e)
            throw Exception("채팅방 접속에 실패 하였습니다.")
        }
    }


    fun closeConnection() {
        // disconnect
        stomp.disconnect()
    }

    fun connectToWebSocket() {
        // connect
        stomp.connect()
    }

}