package com.sarang.torang.repository.comment.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.remote.response.RemoteComment
import com.sarang.torang.repository.comment.CommentRepository

@Composable
fun CommentRepositoryTest(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
    var error by remember { mutableStateOf("") }
    Column(
        Modifier
            .height(LocalConfiguration.current.screenHeightDp.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Text(text = "CommentRepositoryTest", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        GetCommentFlow(commentRepository = commentRepository)
        AddComment(commentRepository = commentRepository)
        LoadMoreReply(commentRepository = commentRepository)
        GetComment(commentRepository)
        GetCommentsWithOneReply(commentRepository)
        DeleteComment()
        ClearComment(commentRepository = commentRepository)
        GetSubComment(commentRepository = commentRepository)
    }
}