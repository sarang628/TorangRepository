package com.sarang.torang.repository

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import com.sarang.torang.data.ToComposable
import kotlinx.coroutines.launch

interface CommentRepository {
    suspend fun getComment(reviewId: Int): RemoteCommentList
    suspend fun getSubComment(parentCommentId: Int): List<RemoteComment>
    suspend fun deleteComment(commentId: Int)
    suspend fun addComment(reviewId: Int, comment: String): RemoteComment
    suspend fun getCommentsWithOneReply(reviewId: Int): RemoteCommentList
    suspend fun getSubComments(commentId: Int): List<RemoteComment>
}

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
        GetComment(commentRepository)
        Button(onClick = { /*TODO*/ }) {
            Text(text = "deleteComment")
        }
        AddComment(commentRepository = commentRepository)
        GetSubComment(commentRepository = commentRepository)
        GetCommentsWithOneReply(commentRepository)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddComment(commentRepository: CommentRepository) {
    var input: TextFieldValue by remember { mutableStateOf(TextFieldValue("test comment")) }
    var commentId: Int by remember { mutableStateOf(329) }
    var parentCommentId: Int by remember { mutableStateOf(145) }
    Button(onClick = { /*TODO*/ }) {
        Text(text = "addComment")
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "comment:")
        OutlinedTextField(value = input, onValueChange = { input = it })
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "reviewId:")
        OutlinedTextField(
            value = TextFieldValue(commentId.toString()),
            onValueChange = { }
        )
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "parentCommentId:")
        OutlinedTextField(
            value = TextFieldValue(parentCommentId.toString()),
            onValueChange = { })
    }
}

@Composable
fun GetComment(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
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
    Text(text = error)
    for (item in list) {
        item.ToComposable()
    }
}

@Composable
fun GetSubComment(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
    Button(onClick = {
        coroutine.launch {
            try {
                list = commentRepository.getSubComment(263)
            } catch (e: Exception) {
                error = e.message.toString()
            }
        }
    }) {
        Text(text = "getSubComment")
    }
    Text(text = error)
    for (item in list) {
        item.ToComposable()
    }
}

@Composable
fun GetCommentsWithOneReply(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var list: RemoteCommentList by remember {
        mutableStateOf(RemoteCommentList(profilePicUrl = "", list = listOf()))
    }
    Button(onClick = {
        coroutine.launch {
            try {
                list = commentRepository.getCommentsWithOneReply(329)
            } catch (e: Exception) {
                error = e.message.toString()
            }
        }
    }) {
        Text(text = "GetCommentsWithOneReply")
    }
    Text(text = error)
    for (item in list.list) {
        item.ToComposable()
    }
}