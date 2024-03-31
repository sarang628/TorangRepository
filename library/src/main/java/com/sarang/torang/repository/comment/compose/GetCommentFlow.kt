package com.sarang.torang.repository.comment.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.sarang.torang.data.entity.CommentEntity
import com.sarang.torang.repository.comment.CommentRepository
import kotlinx.coroutines.launch

@Composable
fun GetCommentFlow(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var reviewId by remember { mutableStateOf(TextFieldValue("329")) }
    var list: List<CommentEntity> by remember { mutableStateOf(mutableListOf()) }

    Row {
        Button(onClick = {
            coroutine.launch {
                commentRepository.getCommentsFlow(reviewId.text.toInt()).collect {
                    list = it
                }
            }
        }) {
            Text(text = "GetCommentFlow")
        }
        OutlinedTextField(
            modifier = Modifier
                .width(100.dp)
                .height(55.dp)
                .padding(0.dp),
            value = reviewId,
            label = { Text(text = "reviewId") },
            onValueChange = { reviewId = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
    Text(text = "size = ${list.size}")
    LazyColumn(Modifier.height(200.dp)) {
        items(list.size) {
            Row(if (list[it].parentCommentId == 0) Modifier else Modifier.padding(start = 20.dp)) {
                Text(text = "${list[it].commentId} ${list[it].userName} ${list[it].comment} isUploading:${list[it].isUploading}")
            }
        }
    }
}