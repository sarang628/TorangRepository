package com.sarang.torang.repository.test.chat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sarang.torang.core.database.model.chat.embedded.ChatRoomParticipants
import com.sarang.torang.data.ChatRoom
import kotlinx.coroutines.launch
import kotlin.text.get

@Composable
fun ChatRoomList(
    chatRooms : List<ChatRoom>,
    onSelectRoom : (Int) -> Unit,
    pagerState : PagerState,
    onDelete : (Int) -> Unit = {}
){
    Column {
        if(chatRooms.isEmpty()){
            Text("ChatRoom is nothing")
        }
        else{
            LazyColumn(Modifier.weight(1f)) {
                items(chatRooms.size) {
                    ChatRoomItem(
                        chatRoom = chatRooms[it],
                        onDelete = onDelete
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatRoomItem(
    onSelectRoom : (Int) -> Unit = {},
    pagerState : PagerState = rememberPagerState() { 0 },
    chatRoom : ChatRoom = ChatRoom(),
    onDelete : (Int) -> Unit = {}
){
    val coroutine = rememberCoroutineScope()
    Column(Modifier.clickable {
        onSelectRoom(chatRoom.roomId)
        coroutine.launch {
            pagerState.animateScrollToPage(1)
        }
    }) {
        Box(Modifier.fillMaxWidth()) {
            Column {
                Text(text = "roomId : ${chatRoom.roomId}")
                Text(text = "participants : " + chatRoom.chatParticipants.map { user -> user.userName }.toString())
                Text(text = "createDate : ${chatRoom.createDate}")
            }

            Button(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 8.dp),
                onClick = { onDelete(chatRoom.roomId) },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Delete")
            }
        }
    }
}