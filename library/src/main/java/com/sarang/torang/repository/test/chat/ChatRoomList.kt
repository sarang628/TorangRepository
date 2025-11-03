package com.sarang.torang.repository.test.chat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.sarang.torang.core.database.model.chat.embedded.ChatRoomParticipants
import com.sarang.torang.data.ChatRoom
import kotlinx.coroutines.launch

@Composable
fun ChatRoomList(
    chatRooms : List<ChatRoom>,
    onSelectRoom : (Int) -> Unit,
    pagerState : PagerState
){
    val coroutine = rememberCoroutineScope()
    Column {
        if(chatRooms.isEmpty()){
            Text("ChatRoom is nothing")
        }
        else{
            LazyColumn(Modifier.weight(1f)) {
                items(chatRooms.size) {
                    Column(Modifier.clickable {
                        onSelectRoom(chatRooms[it].roomId)
                        coroutine.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }) {
                        Text(text = "roomId : ${chatRooms[it].roomId}")
                        Text(text = "participants : " + chatRooms[it].chatParticipants.map { user -> user.userName }.toString())
                        Text(text = "createDate : ${chatRooms[it].createDate}")
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}