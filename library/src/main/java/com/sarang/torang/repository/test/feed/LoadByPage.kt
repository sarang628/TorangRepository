package com.sarang.torang.repository.test.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    LoadByPage1(onLoad = {
                            coroutineScope.launch {
                                feedLoadRepository.loadByPage(it)
                            }
                        },
              feed = feed)
}

@Preview(showBackground = true)
@Composable
fun LoadByPage1(onLoad: (Int) -> Unit = {},
               feed : List<ReviewAndImage> = listOf()) {
    var page by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Button({ onLoad.invoke(page) }) {
                Text("loadByPage")
            }
            Spacer(Modifier.width(10.dp))
            Text(text = "$page page")
            Column {
                IconButton({page++}) { Icon(Icons.Default.KeyboardArrowUp, null) }
                IconButton({page--}) { Icon(Icons.Default.KeyboardArrowDown, null) }
            }

        }


        LazyColumn {
            items(feed){
                Text("$it")
            }
        }
    }
}