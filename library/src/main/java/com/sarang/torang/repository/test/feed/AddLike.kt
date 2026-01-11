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
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun AddLike(
    onAddLike : () -> Unit = {},
    onError: (String) -> Unit = {}
) {
    val coroutine = rememberCoroutineScope()
    var reviewId by remember { mutableStateOf("467") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.width(100.dp),
            value = reviewId,
            onValueChange = {
                try {
                    reviewId = it.toInt().toString()
                } catch (e: Exception) {

                }
            },
            label = {
                Text(text = "reviewId")
            })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = {
            coroutine.launch {
                try {
                    //feedRepository.addLike(reviewId.toInt())
                } catch (e: Exception) {
                    //onError.invoke(e.handle())
                }
            }
        },
            label = { Text(text = "addLike") })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = onAddLike, label = { Text(text = "delLike") })
    }
}