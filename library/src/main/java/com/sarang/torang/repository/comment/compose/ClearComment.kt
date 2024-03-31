package com.sarang.torang.repository.comment.compose

import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.sarang.torang.repository.comment.CommentRepository
import kotlinx.coroutines.launch

@Composable
fun ClearComment(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            commentRepository.clear()
        }
    }) {
        Text(text = "clearComment")
    }
    HorizontalDivider()
}