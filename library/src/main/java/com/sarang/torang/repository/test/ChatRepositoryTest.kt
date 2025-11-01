package com.sarang.torang.repository.test

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
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
import com.google.gson.GsonBuilder
import com.sarang.torang.core.database.model.chat.ChatEntityWithUser
import com.sarang.torang.core.database.model.chat.ChatRoomWithParticipantsAndUsers
import com.sarang.torang.repository.ChatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
            ChatFlow(
                isChatRoomLoading = isChatRoomLoading,
                isConnectSocket = isConnectSocket,
                selectedRoomId = selectedRoomId,
                chatRepository = chatRepository,
                onChatRoomLoading = { isChatRoomLoading = it },
                onError = { error = it }
            )
            ChatTab(pagerState = pagerState)
            ChatPager(
                pagerState = pagerState,
                onSelectRoom = {
                    count++
                    selectedRoomId = it
                },
                list = list,
                list1 = list1,
                selectedRoomId = selectedRoomId,
                chatRepository = chatRepository,
                image = image,
                onText = { text = it },
                text = text,
                onError = { error = it },
                show = show,
                onShow = { show = it }
            )
        }
        galleryBottomSheetCompose.invoke(show, { show = false }, {
            coroutine.launch {
                chatRepository.addImage(roomId = selectedRoomId, message = it)
                show = false
            }
        })
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ChatFlow(isConnectSocket : Boolean,
                     chatRepository: ChatRepository,
                     selectedRoomId : Int,
                     isChatRoomLoading : Boolean,
                     onChatRoomLoading : (Boolean) -> Unit,
                     onError : (String) -> Unit
){
    val coroutine = rememberCoroutineScope()
    FlowRow {
        AssistChip(
            onClick = {
                try {

                } catch (e: Exception) {
                    coroutine.launch {
                        onError(e.message.toString())
                        delay(1000)
                        onError("")
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
                    onError(e.message.toString())
                    delay(1000)
                    onError("")
                }
            }
        }, label = { Text(text = "채팅종료") })

        AssistChip(onClick = {
            coroutine.launch {
                onChatRoomLoading(true)
                try {
                    chatRepository.refreshAllChatRooms()
                } catch (e: Exception) {
                    onError(e.toString())
                    delay(1000)
                    onError("")
                }
                onChatRoomLoading(false)
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChatTab(pagerState : PagerState){
    val coroutine = rememberCoroutineScope()
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
}

@Composable
private fun ChatPager(
    pagerState : PagerState,
    list : List<ChatRoomWithParticipantsAndUsers>,
    list1 : List<ChatEntityWithUser>,
    onSelectRoom : (Int) -> Unit,
    selectedRoomId: Int,
    chatRepository: ChatRepository,
    image: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    onText : (String)->Unit = {},
    text : String,
    onError : (String) -> Unit,
    show : Boolean,
    onShow : (Boolean) -> Unit
){
    val coroutine = rememberCoroutineScope()
    HorizontalPager(state = pagerState) {
        if (it == 0) {
            Column {
                Text(text = "ChatRoomList")
                LazyColumn(Modifier.weight(1f)) {
                    items(list.size) {
                        Column(Modifier.clickable {
                            onSelectRoom(list[it].chatRoomEntity.roomId)
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
                                                onClick = { },
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
                            onValueChange = { onText(it) },
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
                                        onError("채팅방을 선택해 주세요.")
                                        delay(1000)
                                        onError("")
                                    }
                                    onText("")
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
                                        onShow(true)
                                    } else {
                                        onError("채팅방을 선택해 주세요.")
                                        delay(1000)
                                        onError("")
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
