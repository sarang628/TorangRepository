package com.sarang.torang.repository.comment.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.sarang.torang.repository.comment.CommentRepository
import kotlinx.coroutines.launch

@Composable
fun LoadMoreReply(commentRepository: CommentRepository) {
    var commentId by remember { mutableStateOf(TextFieldValue("329")) }
    val coroutine = rememberCoroutineScope()
    Row {
        Button(onClick = {
            coroutine.launch {
                commentRepository.loadMoreReply(commentId.text.toInt())
            }
        }) {
            Text(text = "LoadMore")
        }
        OutlinedTextField(
            value = commentId,
            label = { Text(text = "commentId") },
            onValueChange = { commentId = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }

}
