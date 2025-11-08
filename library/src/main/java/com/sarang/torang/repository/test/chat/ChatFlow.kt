package com.sarang.torang.repository.test.chat

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sarang.torang.repository.ChatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ChatFlow(isConnectSocket : Boolean,
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
                    chatRepository.refreshAllChatRooms().getOrThrow()
                } catch (e: Throwable) {
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