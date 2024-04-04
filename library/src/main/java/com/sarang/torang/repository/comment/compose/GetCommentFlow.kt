package com.sarang.torang.repository.comment.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
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
                list[it].let {
                    Comment(name = it.userName, date = it.createDate, comment = it.comment, isUploading = it.isUploading)
                }
            }
        }
    }
}


@Composable
fun Comment(
    name: String,
    date: String,
    comment: String,
    isUploading: Boolean = false
) {
    Column(Modifier.padding(bottom = 3.dp, start = 3.dp)) {
        Row {
            Text(modifier = Modifier.padding(end = 3.dp), text = name)
            Text(modifier = Modifier.padding(end = 3.dp), text = date)
            if (isUploading)
                Text(text = "Uploading")
        }
        Text(text = comment)
        HorizontalDivider()
    }
}


@Preview
@Composable
fun previewComment() {
    Column {
        Comment(name = "name", date = "date", comment = "comment", isUploading = true)
        Comment(name = "name1", date = "date1", comment = "comment1")
    }
}