package com.sarang.torang.repository.test.feed

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PageFeed(onFindByPage: () -> Unit = {}) {
    var reviewId by remember { mutableStateOf("1") }
    val coroutine = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.width(100.dp),
            value = reviewId,
            onValueChange = { reviewId = it },
            label = {
                Text(text = "page")
            })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = onFindByPage, label = {
            Text(text = "getFeed")
        })
    }
}