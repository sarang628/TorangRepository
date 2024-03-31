package com.sarang.torang.repository.comment.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.ToComposable
import com.sarang.torang.repository.comment.CommentRepository
import kotlinx.coroutines.launch

@Composable
fun GetCommentsWithOneReply(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var reviewId by remember { mutableStateOf(TextFieldValue("329")) }
    var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
    Row {
        Button(onClick = {
            coroutine.launch {
                try {
                    list = commentRepository.getCommentsWithOneReply(reviewId.text.toInt()).list
                } catch (e: Exception) {
                    error = e.message.toString()
                }
            }
        }) {
            Text(text = "getCommentsWithOneReply")
        }
        OutlinedTextField(
            value = reviewId,
            onValueChange = { reviewId = it },
            label = { Text(text = "reviewId") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
    Text(text = error)
    for (item in list) {
        item.ToComposable()
        Spacer(modifier = Modifier.height(10.dp))
    }
    HorizontalDivider()
}