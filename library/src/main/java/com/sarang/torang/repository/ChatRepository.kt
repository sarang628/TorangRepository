package com.sarang.torang.repository

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
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
import com.sarang.torang.data.entity.ChatEntity
import com.sarang.torang.data.entity.ChatEntityWithUser
import com.sarang.torang.data.entity.ChatRoomEntity
import com.sarang.torang.data.entity.ChatRoomWithParticipantsAndUsers
import com.sarang.torang.data.entity.ChatRoomWithParticipantsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


interface ChatRepository {
    // 내 리뷰 삭제
    suspend fun loadChatRoom()
    suspend fun loadContents(roomId: Int)
    fun getChatRoom(): Flow<List<ChatRoomWithParticipantsEntity>>
    suspend fun getUserOrCreateRoomByUserId(userId: Int): ChatRoomWithParticipantsAndUsers
    fun getContents(roomId: Int): Flow<List<ChatEntityWithUser>>
    fun getChatRoomsWithParticipantsAndUsers(): Flow<List<ChatRoomWithParticipantsAndUsers>>
    suspend fun addChat(roomId: Int, message: String)
}

@Composable
fun ChatRepositoryTest(chatRepository: ChatRepository) {
    val coruntine = rememberCoroutineScope()
    var list: List<ChatRoomWithParticipantsAndUsers> by remember { mutableStateOf(listOf()) }
    var list1: List<ChatEntityWithUser> by remember { mutableStateOf(listOf()) }
    var selectedRoomId by remember { mutableIntStateOf(-1) }
    var count by remember { mutableIntStateOf(-1) }
    val height = LocalConfiguration.current.screenHeightDp.dp - 100.dp
    var text by remember { mutableStateOf("") }

    LaunchedEffect(key1 = "") {
        coruntine.launch {
            chatRepository.loadChatRoom()
            chatRepository.getChatRoomsWithParticipantsAndUsers().collect {
                list = it
            }
        }
    }

    LaunchedEffect(key1 = count) {
        if (selectedRoomId != -1) {
            chatRepository.loadContents(selectedRoomId)
            chatRepository.getContents(selectedRoomId).collect {
                list1 = it
            }
        }
    }

    HorizontalDivider(color = Color.LightGray)
    Text(text = "ChatRepositoryTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)

    Column(modifier = Modifier.height(height))
    {
        Text(text = "ChatRoomList")
        LazyColumn(Modifier.weight(1f)) {
            items(list.size) {
                Column(Modifier.clickable {
                    count++
                    selectedRoomId = list[it].chatRoomEntity.roomId
                }) {
                    Text(text = "roomId : ${list[it].chatRoomEntity.roomId}")
                    Text(text = "participants : " + list[it].participantsWithUsers.map { it.userEntity.userName }
                        .toString())
                    Text(text = "createDate : ${list[it].chatRoomEntity.createDate}")
                    HorizontalDivider()
                }
            }
        }
        Text(text = "Chat (roomId : ${selectedRoomId})")
        Box(modifier = Modifier.weight(1f))
        {
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
                        coruntine.launch {
                            if (selectedRoomId != -1)
                                chatRepository.addChat(selectedRoomId, text)
                            text = ""
                        }
                    },
                    Modifier
                        .weight(0.2f)
                        .height(55.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "send")
                }
            }
        }
    }
}