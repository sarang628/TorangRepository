package com.sarang.torang.repository

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
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
import java.util.UUID


interface ChatRepository {
    /**
     * 채팅방 목록 가져오기
     */
    suspend fun loadChatRoom()

    /**
     * 채팅 내용 가져오기
     */
    suspend fun loadContents(roomId: Int)

    /**
     * 채팅방 목록 가져오기
     */
    fun getChatRoom(): Flow<List<ChatRoomWithParticipantsEntity>>

    /**
     * 채팅방 목록 가져오기
     */
    fun getChatRoom1(): Flow<List<ChatRoomEntity>>

    /**
     * 채팅방 생성
     */
    suspend fun getUserOrCreateRoomByUserId(userId: Int): ChatRoomWithParticipantsAndUsers

    /**
     * 채팅 내용 가져오기
     */
    fun getContents(roomId: Int): Flow<List<ChatEntityWithUser>>

    /**
     * 채팅방 목록, 참여자 목록 가져오기
     */
    fun getChatRoomsWithParticipantsAndUsers(): Flow<List<ChatRoomWithParticipantsAndUsers>>

    /**
     * 채팅방에 메시지 추가
     */
    suspend fun addChat(roomId: Int, message: String, uuid: String = UUID.randomUUID().toString())

    /**
     * 채팅방에 이미지 추가
     */
    suspend fun addImage(
        roomId: Int,
        message: List<String>,
        uuid: String = UUID.randomUUID().toString(),
    )

    /**
     * 채팅방 목록, 참여자 목록 , 채팅 모두 삭제
     *
     * 로그아웃 시 필요한 기능으로 추가 됨.
     */
    suspend fun removeAll()

    /**
     * 채팅방 구독
     */
    suspend fun subscribe(roomId: Int)

    /**
     *  STOMP 소켓 이벤트
     */
    fun event(coroutineScope: CoroutineScope): Flow<Message>

    /**
     * 채팅방 구독 해제
     */
    fun unSubscribe(topic: Int)

    /**
     * 전송 실패한 이미지 갱신하기
     */
    suspend fun updateFailedUploadImage(roomId: Int)
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChatRepositoryTest(
    chatRepository: ChatRepository,
    image: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    galleryBottomSheetCompose: @Composable (Boolean, onHidden: () -> Unit, onSend: (List<String>) -> Unit) -> Unit,
) {
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
    var show by remember { mutableStateOf(false) }
    val pagerState = rememberPagerState { 2 }

    LaunchedEffect(key1 = count) {
        if (selectedRoomId != -1) {
            try {
                chatRepository.subscribe(selectedRoomId)
            } catch (e: Exception) {
                error = "openChatRoom error: ${e.message.toString()}"
                delay(1000)
                error = ""
            }

            chatRepository.loadContents(selectedRoomId)
            chatRepository.updateFailedUploadImage(selectedRoomId)
            chatRepository.getContents(selectedRoomId).collect {
                list1 = it
            }

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

    if (error.isNotEmpty()) Text(
        text = "error: ${error}",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier.height(height)) {

        Column(
            modifier = Modifier.height(height)
        ) {
            FlowRow {
                AssistChip(
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
                    colors = AssistChipDefaults.assistChipColors(containerColor = if (!isConnectSocket) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary),
                    label = {
                        Text(text = if (!isConnectSocket) "DisConnectedSocket" else "ConnectedSocket")
                    })

                AssistChip(onClick = {
                    coroutine.launch {
                        try {
                            chatRepository.unSubscribe(selectedRoomId)
                        } catch (e: Exception) {
                            error = e.message.toString()
                            delay(1000)
                            error = ""
                        }
                    }
                }, label = { Text(text = "채팅종료") })

                AssistChip(onClick = {
                    coroutine.launch {
                        isChatRoomLoading = true
                        try {
                            chatRepository.loadChatRoom()
                        } catch (e: Exception) {
                            error = e.toString()
                            delay(1000)
                            error = ""
                        }
                        isChatRoomLoading = false
                    }
                }, label = {
                    Row {
                        Text(text = "Load ChatRoom")
                        Spacer(modifier = Modifier.width(8.dp))
                        if (isChatRoomLoading) CircularProgressIndicator(
                            color = Color.White, modifier = Modifier.size(20.dp), strokeWidth = 2.dp
                        )
                    }
                })
            }

            PrimaryTabRow(selectedTabIndex = pagerState.currentPage) {
                Tab(selected = pagerState.currentPage == 0, onClick = {
                    coroutine.launch {
                        pagerState.animateScrollToPage(0)
                    }
                }) {
                    TextButton(onClick = {
                        coroutine.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    }) {
                        Text(text = "ChatRoom")
                    }

                }
                Tab(selected = pagerState.currentPage == 1, onClick = {
                    coroutine.launch {
                        pagerState.animateScrollToPage(1)
                    }
                }) {
                    TextButton(onClick = {
                        coroutine.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }) {
                        Text(text = "Chat")
                    }
                }
            }
            HorizontalPager(state = pagerState) {
                if (it == 0) {
                    Column {
                        Text(text = "ChatRoomList")
                        LazyColumn(Modifier.weight(1f)) {
                            items(list.size) {
                                Column(Modifier.clickable {
                                    count++
                                    selectedRoomId = list[it].chatRoomEntity.roomId
                                    coroutine.launch {
                                        pagerState.animateScrollToPage(1)
                                    }
                                }) {
                                    Text(text = "roomId : ${list[it].chatRoomEntity.roomId}")
                                    Text(text = "participants : " + list[it].participantsWithUsers.map { it.userName }
                                        .toString())
                                    Text(text = "createDate : ${list[it].chatRoomEntity.createDate}")
                                    HorizontalDivider()
                                }
                            }
                        }
                    }
                } else if (it == 1) {
                    //채팅방
                    Column {
                        Text(text = "Chat (roomId : ${selectedRoomId})")
                        Box(modifier = Modifier.weight(1f)) {
                            LazyColumn(Modifier.padding(bottom = 50.dp)) {
                                items(list1.size) {
                                    Column {
                                        Text(text = list1[it].userEntity.userName)
                                        Text(text = list1[it].chatEntity.message)
                                        Text(text = "${list1[it].chatEntity.createDate} ${if (list1[it].chatEntity.sending) "isSending.." else ""}")
                                        //이미지
                                        list1[it].images.forEach {
                                            Box() {
                                                image.invoke(
                                                    Modifier.size(50.dp),
                                                    it.localUri,
                                                    20.dp,
                                                    20.dp,
                                                    ContentScale.Crop
                                                )
                                                if (it.failed) {
                                                    IconButton(
                                                        onClick = { /*TODO*/ },
                                                        modifier = Modifier.align(
                                                            Alignment.Center
                                                        )
                                                    ) {
                                                        Icon(
                                                            imageVector = Icons.Default.Clear,
                                                            contentDescription = ""
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            Row(
                                Modifier
                                    .align(Alignment.BottomCenter)
                                    .height(60.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextField(
                                    value = text,
                                    onValueChange = { text = it },
                                    Modifier.weight(0.6f)
                                )
                                Button(
                                    onClick = {
                                        coroutine.launch {
                                            if (selectedRoomId != -1) {
                                                chatRepository.addChat(
                                                    roomId = selectedRoomId,
                                                    message = text
                                                )
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
                                Button(
                                    onClick = {
                                        coroutine.launch {
                                            if (selectedRoomId != -1) {
                                                show = true
                                            } else {
                                                error = "채팅방을 선택해 주세요."
                                                delay(1000)
                                                error = ""
                                            }
                                        }
                                    },
                                    Modifier
                                        .weight(0.2f)
                                        .height(55.dp), shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(text = "Image")
                                }
                            }
                        }
                    }
                }
            }

        }
        galleryBottomSheetCompose.invoke(show, { show = false }, {
            coroutine.launch {
                chatRepository.addImage(roomId = selectedRoomId, message = it)
                show = false
            }
        })
    }
}