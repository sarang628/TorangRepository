package com.sarang.torang.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import com.sarang.torang.data.ToComposable
import com.sarang.torang.data.entity.CommentEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface CommentRepository {
    suspend fun getComment(reviewId: Int): RemoteCommentList
    suspend fun getSubComment(parentCommentId: Int): List<RemoteComment>
    suspend fun deleteComment(commentId: Int)
    suspend fun addComment(reviewId: Int, comment: String): RemoteComment
    suspend fun addReply(reviewId: Int, comment: String, parentCommentId: Int): RemoteComment
    suspend fun getCommentsWithOneReply(reviewId: Int): RemoteCommentList
    suspend fun getSubComments(commentId: Int): List<RemoteComment>
    fun getCommentsFlow(reviewId: Int): Flow<List<CommentEntity>>
    suspend fun clear()
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
        GetCommentFlow(commentRepository = commentRepository)
        GetComment(commentRepository)
        GetCommentsWithOneReply(commentRepository)
        DeleteComment()
        ClearComment(commentRepository = commentRepository)
        AddComment(commentRepository = commentRepository)
        GetSubComment(commentRepository = commentRepository)
    }
}

@Composable
fun GetCommentFlow(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var reviewId by remember { mutableStateOf(TextFieldValue("329")) }
    var list: List<CommentEntity> by remember { mutableStateOf(mutableListOf()) }

    for (commentEntity in list) {
        Text(text = "${commentEntity.commentId}")
    }

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
            value = reviewId,
            label = { Text(text = "reviewId") },
            onValueChange = { reviewId = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun DeleteComment() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "deleteComment")
    }
    HorizontalDivider()
}

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

@Composable
fun AddComment(commentRepository: CommentRepository) {
    var input: TextFieldValue by remember { mutableStateOf(TextFieldValue("test comment")) }
    var reviewId: TextFieldValue by remember { mutableStateOf(TextFieldValue("329")) }
    var parentCommentId: TextFieldValue by remember { mutableStateOf(TextFieldValue("145")) }
    var result: RemoteComment? by remember { mutableStateOf(null) }
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            if (parentCommentId.text.isEmpty()) {
                result = commentRepository.addComment(reviewId.text.toInt(), comment = input.text)
            } else {
                result = commentRepository.addReply(
                    reviewId = reviewId.text.toInt(),
                    comment = input.text,
                    parentCommentId = parentCommentId.text.toInt()
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

@Composable
fun GetComment(commentRepository: CommentRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var reviewId by remember { mutableStateOf(TextFieldValue("329")) }
    var list: List<RemoteComment> by remember { mutableStateOf(arrayListOf()) }
    Row {
        Button(onClick = {
            coroutine.launch {
                try {
                    list = commentRepository.getComment(reviewId.text.toInt()).list
                } catch (e: Exception) {
                    error = e.message.toString()
                }
            }
        }) {
            Text(text = "getComment")
        }
        OutlinedTextField(
            value = reviewId,
            label = { Text(text = "reviewId") },
            onValueChange = { reviewId = it },
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
    HorizontalDivider()
}

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