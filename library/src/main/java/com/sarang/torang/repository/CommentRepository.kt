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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import kotlinx.coroutines.launch

interface CommentRepository {
    suspend fun getComment(reviewId: Int): RemoteCommentList
    suspend fun getSubComment(parentCommentId: Int): List<RemoteComment>
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
            Text(text = "Comment", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Button(onClick = {
                coroutine.launch {
                    try {
                        list = commentRepository.getComment(329).list
                    } catch (e: Exception) {
                        error = e.message.toString()
                    }
                }
            }) {
                Text(text = "getComment")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "deleteComment")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "addComment()")
            }
            Button(onClick = {
                coroutine.launch {
                    try {
                        list = commentRepository.getSubComment(145)
                    } catch (e: Exception) {
                        error = e.message.toString()
                    }
                }
            }) {
                Text(text = "getSubComment")
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
                    Column {
                        Text(text = "comment_id = ${list[it].comment_id}")
                        Text(text = "comment = ${list[it].comment}")
                        Text(text = "create_date = ${list[it].create_date}")
                        Text(text = "comment_like_id = ${list[it].comment_like_id}")
                        Text(text = "comment_like_count = ${list[it].comment_like_count}")
                        Text(text = "parentCommentId = ${list[it].parentCommentId}")
                        Text(text = "sub_comment_count = ${list[it].sub_comment_count}")
                        Text(text = "tagUser = ${list[it].tagUser}")
                    }
                    HorizontalDivider(Modifier.height(10.dp))
                }
            })

        }
    }

}