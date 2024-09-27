package com.sarang.torang.repository

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gmail.bishoybasily.stomp.lib.Message
import com.google.gson.GsonBuilder
import com.sarang.torang.data.entity.ChatEntityWithUser
import com.sarang.torang.data.entity.ChatRoomEntity
import com.sarang.torang.data.entity.ChatRoomWithParticipantsAndUsers
import com.sarang.torang.data.entity.ChatRoomWithParticipantsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


interface ChatRepository {
    // 내 리뷰 삭제
    suspend fun loadChatRoom()
    suspend fun loadContents(roomId: Int)
    fun getChatRoom(): Flow<List<ChatRoomWithParticipantsEntity>>
    fun getChatRoom1(): Flow<List<ChatRoomEntity>>
    suspend fun getUserOrCreateRoomByUserId(userId: Int): ChatRoomWithParticipantsAndUsers
    fun getContents(roomId: Int): Flow<List<ChatEntityWithUser>>
    fun getChatRoomsWithParticipantsAndUsers(): Flow<List<ChatRoomWithParticipantsAndUsers>>
    suspend fun addChat(roomId: Int, message: String)

    /**
     * 채팅방 목록, 참여자 목록 , 채팅 모두 삭제
     *
     * 로그아웃 시 필요한 기능으로 추가 됨.
     */
    suspend fun removeAll()
    suspend fun openChatRoom(roomId: Int)

    fun event(coroutineScope: CoroutineScope): Flow<Message>
    fun unSubscribe(topic: Int)
}

@Composable
fun ChatRepositoryTest(chatRepository: ChatRepository) {
    val coroutine = rememberCoroutineScope()
    var list: List<ChatRoomWithParticipantsAndUsers> by remember { mutableStateOf(listOf()) }
    var list1: List<ChatEntityWithUser> by remember { mutableStateOf(listOf()) }
    var selectedRoomId by remember { mutableIntStateOf(-1) }
    var count by remember { mutableIntStateOf(-1) }
    val height = LocalConfiguration.current.screenHeightDp.dp - 100.dp
    var text by remember { mutableStateOf("") }
    var isChatRoomLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }
    var isConnectSocket by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = count) {
        if (selectedRoomId != -1) {
            try {
                chatRepository.openChatRoom(selectedRoomId)
            } catch (e: Exception) {
                error = "openChatRoom error: ${e.message.toString()}"
                delay(1000)
                error = ""
            }

            //chatRepository.loadContents(selectedRoomId)
//                chatRepository.getContents(selectedRoomId).collect {
//                    list1 = it
//                }

        }
    }

    LaunchedEffect(key1 = "AAA") {
        coroutine.launch {
            chatRepository.event(coroutine).collect {
                Log.d(
                    "__ChatRepositoryTest",
                    "event: ${GsonBuilder().setPrettyPrinting().create().toJson(it)}"
                )
                if (it.command == "CONNECTED") {
                    isConnectSocket = true
                } else if (it.command == "DISCONNECTED") {
                    isConnectSocket = false
                }
            }
        }
    }

    LaunchedEffect(key1 = "") {
        coroutine.launch {
            chatRepository.getChatRoomsWithParticipantsAndUsers().collect {
                Log.d(
                    "__ChatRepositoryTest", "received chat room list : ${
                        //GsonBuilder().setPrettyPrinting().create().toJson(it)
                        it
                    }"
                )
                list = it
            }
        }
    }

    HorizontalDivider(color = Color.LightGray)
    Text(text = "ChatRepositoryTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)

    if (error.isNotEmpty())
        Text(text = "error: ${error}", fontSize = 16.sp, fontWeight = FontWeight.Bold)

    Column(modifier = Modifier.height(height)) {
        Button(
            onClick = {
                try {

                } catch (e: Exception) {
                    coroutine.launch {
                        error = e.message.toString()
                        delay(1000)
                        error = ""
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = if (!isConnectSocket) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary)
        ) {
            Text(text = if (!isConnectSocket) "DisConnectedSocket" else "ConnectedSocket")
        }

        Button(onClick = {
            coroutine.launch {
                try {
                    chatRepository.unSubscribe(selectedRoomId)
                } catch (e: Exception) {
                    error = e.message.toString()
                    delay(1000)
                    error = ""
                }
            }
        }) {
            Text(text = "채팅종료")
        }

        Button(onClick = {
            coroutine.launch {
                isChatRoomLoading = true
                chatRepository.loadChatRoom()
                isChatRoomLoading = false
            }
        }

        ) {
            Row {
                Text(text = "Load ChatRoom")
                Spacer(modifier = Modifier.width(8.dp))
                if (isChatRoomLoading) CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp
                )
            }
        }

        Text(text = "ChatRoomList")
        LazyColumn(Modifier.weight(1f)) {
            items(list.size) {
                Column(Modifier.clickable {
                    count++
                    selectedRoomId = list[it].chatRoomEntity.roomId
                }) {
                    Text(text = "roomId : ${list[it].chatRoomEntity.roomId}")
                    Text(text = "participants : " + list[it].participantsWithUsers.map { it.userName }
                        .toString())
                    Text(text = "createDate : ${list[it].chatRoomEntity.createDate}")
                    HorizontalDivider()
                }
            }
        }
        Text(text = "Chat (roomId : ${selectedRoomId})")
        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(Modifier.padding(bottom = 50.dp)) {
                items(list1.size) {
                    Column {
                        Text(text = list1[it].userEntity.userName)
                        Text(text = list1[it].chatEntity.message)
                        Text(text = list1[it].chatEntity.createDate)
                    }
                }
            }
            Row(
                Modifier
                    .align(Alignment.BottomCenter)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(value = text, onValueChange = { text = it }, Modifier.weight(0.8f))
                Button(
                    onClick = {
                        coroutine.launch {
                            if (selectedRoomId != -1) {
                                chatRepository.addChat(selectedRoomId, text)
                            } else {
                                error = "채팅방을 선택해 주세요."
                                delay(1000)
                                error = ""
                            }
                            text = ""
                        }
                    },
                    Modifier
                        .weight(0.2f)
                        .height(55.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "send")
                }
            }
        }
    }
}