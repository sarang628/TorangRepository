package com.sryang.torang_repository.repository.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.sryang.library.entity.Feed
import kotlinx.coroutines.launch
import java.util.stream.Collectors


interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun loadFeed(): List<Feed>
}

@Composable
fun FeedRepositoryTest(feedRepository: FeedRepository) {
    var list = remember { mutableStateListOf<Feed>() }
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                list.addAll(feedRepository.loadFeed())
            }
        }) {

        }
        Text(text = list.stream().map { it.toString() }.collect(Collectors.toList()).toString())
    }
}