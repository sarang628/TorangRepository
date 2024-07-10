package com.sarang.torang.repository.comment.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.sarang.torang.data.remote.response.RemoteComment
import com.sarang.torang.repository.comment.CommentRepository
import kotlinx.coroutines.launch

@Composable
fun AddComment(commentRepository: CommentRepository) {
    var input: TextFieldValue by remember { mutableStateOf(TextFieldValue("test comment")) }
    var reviewId: TextFieldValue by remember { mutableStateOf(TextFieldValue("329")) }
    var parentCommentId: TextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var result: RemoteComment? by remember { mutableStateOf(null) }
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            if (parentCommentId.text.isEmpty()) {
                commentRepository.addComment(
                    reviewId.text.toInt(),
                    comment = input.text,
                    onLocalUpdated = {})
            } else {
                commentRepository.addReply(
                    reviewId = reviewId.text.toInt(),
                    comment = input.text,
                    parentCommentId = parentCommentId.text.toInt(), onLocalUpdated = {}
                )
            }
        }
    }) {
        Text(text = "addComment")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = input,
            label = { Text(text = "comment") },
            onValueChange = { input = it })
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = reviewId,
            singleLine = true,
            label = { Text(text = "reviewId") },
            onValueChange = { reviewId = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = parentCommentId,
            singleLine = true,
            label = { Text(text = "parentCommentId") },
            onValueChange = { parentCommentId = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
    Text(text = "result :  ${result}")
    HorizontalDivider()
}