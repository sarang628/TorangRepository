package com.sarang.torang.repository.test.chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sarang.torang.core.database.model.chat.embedded.ChatMessageUserImages
import com.sarang.torang.repository.ChatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ChatRoom(
    selectedRoomId: Int,
    chats : List<ChatMessageUserImages>,
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
                items(chats.size) {
                    Column {
                        Text(text = chats[it].user.userName)
                        Text(text = chats[it].chatMessage.message)
                        Text(text = "${chats[it].chatMessage.createDate} ${if (chats[it].chatMessage.sending) "isSending.." else ""}")
                        //이미지
                        chats[it].images.forEach {
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
