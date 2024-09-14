package com.sarang.torang.repository

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.entity.ChatEntity
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
    fun getContents(roomId: Int): Flow<List<ChatEntity>>
    fun getChatRoomsWithParticipantsAndUsers(): Flow<List<ChatRoomWithParticipantsAndUsers>>
}

@Composable
fun ChatRepositoryTest(chatRepository: ChatRepository) {
    val coruntine = rememberCoroutineScope()
    var list: List<ChatRoomWithParticipantsAndUsers> by remember { mutableStateOf(listOf()) }
    var list1: List<ChatEntity> by remember { mutableStateOf(listOf()) }
    var selectedRoomId by remember { mutableIntStateOf(-1) }
    var count by remember { mutableIntStateOf(-1) }

    LaunchedEffect(key1 = "") {
        coruntine.launch {
            chatRepository.loadChatRoom()
            chatRepository. getChatRoomsWithParticipantsAndUsers().collect {
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

    Box(modifier = Modifier.height(200.dp))
    {
        LazyColumn {
            items(list.size) {
                Column(Modifier.clickable {
                    count++
                    selectedRoomId = list[it].chatRoomEntity.roomId
                }) {
                    Text(text = "roomId : ${list[it].chatRoomEntity.roomId}")
                    Text(text = "createDate : ${list[it].chatRoomEntity.createDate}")
                    Text(text = list[it].participantsWithUsers.toString())
                }
            }
        }
    }
    HorizontalDivider(color = Color.LightGray)
    Box(modifier = Modifier.height(200.dp))
    {
        LazyColumn {
            items(list1.size) {
                Column {
                    Text(text = "${list1[it].roomId}")
                    Text(text = "${list1[it].userId}")
                    Text(text = list1[it].message)
                    Text(text = list1[it].createDate)
                }
            }
        }
    }
}