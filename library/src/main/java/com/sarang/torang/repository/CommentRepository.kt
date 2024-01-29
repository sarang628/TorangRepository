package com.sarang.torang.repository

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import kotlinx.coroutines.launch

interface CommentRepository {
    suspend fun getComment(reviewId: Int): RemoteCommentList
    suspend fun deleteComment(commentId: Int)
    suspend fun addComment(reviewId: Int, comment: String): RemoteComment
}

@Composable
fun CommentRepositoryTest(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
    var error by remember { mutableStateOf("") }
    Row {
        Column(
            Modifier
                .weight(0.3f)
                .height(300.dp)
        ) {
            Button(onClick = {
                coroutine.launch {
                    try {
                        list = commentRepository.getComment(329).list
                    } catch (e: Exception) {
                        error = e.message.toString()
                    }
                }
            }) {
                Text(text = "getComment()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "deleteComment()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "addComment()")
            }
        }
        Column(
            Modifier
                .weight(0.7f)
                .background(Color.LightGray)
                .height(300.dp)
        ) {

            Text(text = error)
            LazyColumn(content = {
                items(list.size) {
                    HorizontalDivider()
                    Text(text = list[it].toString())
                    HorizontalDivider(Modifier.height(10.dp))
                }
            })

        }
    }

}