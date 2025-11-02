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
import com.sarang.torang.core.database.model.chat.embedded.ChatMessageUserImages
import com.sarang.torang.core.database.model.chat.embedded.ChatRoomParticipants
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChatRepositoryTest(
    tag : String = "__ChatRepositoryTest",
    loginRepository: LoginRepository,
    chatRepository: ChatRepository,
    image: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    galleryBottomSheetCompose: @Composable (Boolean, onHidden: () -> Unit, onSend: (List<String>) -> Unit) -> Unit,
) {
    val coroutine           : CoroutineScope                = rememberCoroutineScope()
    var list                : List<ChatRoomParticipants>    by remember { mutableStateOf(listOf()) }
    var list1               : List<ChatMessageUserImages>   by remember { mutableStateOf(listOf()) }
    var selectedRoomId      : Int                           by remember { mutableIntStateOf(-1) }
    var count               : Int                           by remember { mutableIntStateOf(-1) }
    val height              : Dp                            = LocalConfiguration.current.screenHeightDp.dp - 100.dp
    var text                : String                        by remember { mutableStateOf("") }
    var isChatRoomLoading   : Boolean                       by remember { mutableStateOf(false) }
    var error               : String                        by remember { mutableStateOf("") }
    var isConnectSocket     : Boolean                       by remember { mutableStateOf(false) }
    var show                : Boolean                       by remember { mutableStateOf(false) }
    val pagerState          : PagerState                    = rememberPagerState { 2 }
    val isLoginFlow         : Flow<Boolean>                 = loginRepository.isLogin
    var isLogin             : Boolean                       by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isLoginFlow.collect {
            isLogin = it
        }
    }

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

    LaunchedEffect(Unit) {
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

    LaunchedEffect(key1 = Unit) {
        coroutine.launch {
            chatRepository.getAllChatRooms().collect {
                Log.d(
                    tag, "received chat room list : ${
                        GsonBuilder().setPrettyPrinting().create().toJson(it)
                    }"
                )
                list = it
            }
        }
    }

    if (error.isNotEmpty()) Text(
        text = "error: ${error}",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier.height(height)) {

        if(isLogin) {
            Column(
                modifier = Modifier.height(height)
            ) {
                HorizontalDivider(color = Color.LightGray)
                Text(text = "ChatRepositoryTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
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
        else{
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "로그인을 해주세요."
            )
        }
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
    list : List<ChatRoomParticipants>,
    list1 : List<ChatMessageUserImages>,
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
            ChatRoomList(
                list = list,
                onSelectRoom = onSelectRoom,
                pagerState = pagerState
            )
        } else if (it == 1) {
            //채팅방
            ChatRoom(
                selectedRoomId = selectedRoomId,
                list1 = list1,
                image = image,
                onText = onText,
                text = text,
                chatRepository = chatRepository,
                onError = onError,
                onShow = onShow
            )
        }
    }
}

@Composable
fun ChatRoomList(
    list : List<ChatRoomParticipants>,
    onSelectRoom : (Int) -> Unit,
    pagerState : PagerState
){
    val coroutine = rememberCoroutineScope()
    Column {
        if(list.isEmpty()){
            Text("ChatRoom is nothing")
        }
        else{
            LazyColumn(Modifier.weight(1f)) {
                items(list.size) {
                    Column(Modifier.clickable {
                        onSelectRoom(list[it].chatRoom.roomId)
                        coroutine.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }) {
                        Text(text = "roomId : ${list[it].chatRoom.roomId}")
                        Text(text = "participants : " + list[it].chatParticipants.map { it.userEntity?.userName }
                            .toString())
                        Text(text = "createDate : ${list[it].chatRoom.createDate}")
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}

@Composable
fun ChatRoom(
    selectedRoomId: Int,
    list1 : List<ChatMessageUserImages>,
    image: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    onText : (String)->Unit = {},
    text : String,
    chatRepository: ChatRepository,
    onError : (String) -> Unit,
    onShow : (Boolean) -> Unit
){
    val coroutine = rememberCoroutineScope()
    Column {
        Text(text = "Chat (roomId : ${selectedRoomId})")
        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(Modifier.padding(bottom = 50.dp)) {
                items(list1.size) {
                    Column {
                        Text(text = list1[it].user.userName)
                        Text(text = list1[it].chatMessage.message)
                        Text(text = "${list1[it].chatMessage.createDate} ${if (list1[it].chatMessage.sending) "isSending.." else ""}")
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
