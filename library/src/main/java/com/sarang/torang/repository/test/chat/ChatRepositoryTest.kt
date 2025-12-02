package com.sarang.torang.repository.test.chat

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gmail.bishoybasily.stomp.lib.Message
import com.sarang.torang.data.ChatMessage
import com.sarang.torang.data.ChatRoom
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
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
    val coroutine               : CoroutineScope                = rememberCoroutineScope()
    val chatRooms               : List<ChatRoom>                by chatRepository.getAllChatRoomsFlow().collectAsStateWithLifecycle(initialValue = emptyList())
    var selectedRoomId          : Int                           by remember { mutableIntStateOf(-1) }
    val chats                   : List<ChatMessage>             by chatRepository.getChatsFlow(selectedRoomId).collectAsStateWithLifecycle(emptyList())
    var count                   : Int                           by remember { mutableIntStateOf(-1) }
    val height                  : Dp                            = LocalConfiguration.current.screenHeightDp.dp - 100.dp
    var text                    : String                        by remember { mutableStateOf("") }
    var isChatRoomLoading       : Boolean                       by remember { mutableStateOf(false) }
    var error                   : String                        by remember { mutableStateOf("") }
    val isConnectSocket         : Message                       by chatRepository.event(coroutine).collectAsStateWithLifecycle(initialValue = Message("",""))
    var show                    : Boolean                       by remember { mutableStateOf(false) }
    val pagerState              : PagerState                    = rememberPagerState { 2 }
    val isLogin                 : Boolean                       by loginRepository.isLogin.collectAsStateWithLifecycle(false)
    val backPressedDispatcher   : OnBackPressedDispatcherOwner? = LocalOnBackPressedDispatcherOwner.current

    Scaffold(
        topBar = {
                    TopAppBar(
                        title = { Text(text = "ChatRepositoryTest", fontSize = 20.sp) },
                        navigationIcon = {
                            IconButton({
                                backPressedDispatcher?.onBackPressedDispatcher?.onBackPressed()
                            }) { Icon(Icons.AutoMirrored.Default.ArrowBack, null) }
                        }
                    )
                 },
    ) {
        Box(modifier = Modifier.padding(it).fillMaxSize()) {
            if(isLogin) {
                Column(
                    modifier = Modifier.height(height)
                ) {
                    ChatFlow(
                        isChatRoomLoading = isChatRoomLoading,
                        isConnectSocket = isConnectSocket.command == "CONNECTED",
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
                        chatRooms = chatRooms,
                        chats = chats,
                        selectedRoomId = selectedRoomId,
                        chatRepository = chatRepository,
                        image = image,
                        onText = { text = it },
                        text = text,
                        onError = { error = it },
                        show = show,
                        onShow = { show = it },
                        onDelete = {
                            coroutine.launch {
                                chatRepository.deleteChatRoom(it)
                                chatRepository.deleteParticipantsByChatRoomId(it)
                            }
                        }
                    )
                }
                galleryBottomSheetCompose.invoke(show, { show = false }, {
                    coroutine.launch {
                        chatRepository.addImageChat(roomId = selectedRoomId, message = it)
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


    LaunchedEffect(key1 = count) {
        if (selectedRoomId != -1) {
            try {
                chatRepository.subscribe(selectedRoomId)
            } catch (e: Exception) {
                error = "openChatRoom error: ${e.message.toString()}"
                delay(1000)
                error = ""
            }

            chatRepository.loadChats(selectedRoomId)
            chatRepository.updateFailedUploadImage(selectedRoomId)
        }
    }

    if (error.isNotEmpty()) Text(
        text = "error: ${error}",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}

