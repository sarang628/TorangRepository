package com.sarang.torang.repository.comment.compose

import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sarang.torang.repository.comment.CommentRepository
import kotlinx.coroutines.launch

@Composable
fun GetSubComment(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    //var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
    Button(onClick = {
        coroutine.launch {
            try {
                //list = commentRepository.getSubComment(263)
            } catch (e: Exception) {
                error = e.message.toString()
            }
        }
    }) {
        Text(text = "getSubComment")
    }
    Text(text = error)
    /*for (item in list) {
        item.ToComposable()
    }*/
    HorizontalDivider()
}