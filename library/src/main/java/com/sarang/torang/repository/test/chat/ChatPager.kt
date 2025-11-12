package com.sarang.torang.repository.test.chat

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.sarang.torang.data.ChatMessage
import com.sarang.torang.data.ChatRoom

import com.sarang.torang.repository.ChatRepository

@Composable
internal fun ChatPager(
    pagerState : PagerState,
    chatRooms : List<ChatRoom>,
    chats : List<ChatMessage>,
    onSelectRoom : (Int) -> Unit,
    selectedRoomId: Int,
    chatRepository: ChatRepository,
    image: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    onText : (String)->Unit = {},
    text : String,
    onError : (String) -> Unit,
    show : Boolean,
    onShow : (Boolean) -> Unit,
    onDelete : (Int) -> Unit = {}
){
    val coroutine = rememberCoroutineScope()
    HorizontalPager(state = pagerState) {
        if (it == 0) {
            ChatRoomList(
                chatRooms = chatRooms,
                onSelectRoom = onSelectRoom,
                pagerState = pagerState,
                onDelete = onDelete
            )
        } else if (it == 1) {
            ChatRoom(
                selectedRoomId = selectedRoomId,
                chats = chats,
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