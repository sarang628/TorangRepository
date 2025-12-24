package com.sarang.torang.repository.test.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sarang.torang.data.ReviewAndImage
import com.sarang.torang.repository.feed.FeedLoadRepository
import kotlinx.coroutines.launch

@Composable
fun LoadByPage(feedLoadRepository: FeedLoadRepository) {
    val coroutineScope = rememberCoroutineScope()
    var feed : List<ReviewAndImage> by remember { mutableStateOf(listOf()) }
    LaunchedEffect(Unit) {
        feedLoadRepository.feeds.collect {
            it?.let { feed = it }
        }
    }
    Column {
        Button({
            coroutineScope.launch {
                feedLoadRepository.loadByPage(0)
            }
        }) {
            Text("loadByPage")
        }
        LazyColumn {
            items(feed){
                Text("$it")
            }
        }
    }
}