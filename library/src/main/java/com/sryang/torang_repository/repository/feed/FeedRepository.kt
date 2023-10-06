package com.sryang.torang_repository.repository.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.google.gson.Gson
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun deleteFeedAll()
    suspend fun loadFeed(userId: Int)
    suspend fun addLike(userId: Int, reviewId: Int)
    suspend fun deleteLike(userId: Int, reviewId: Int)

    val feeds1: Flow<List<ReviewAndImageEntity>>
}

@Composable
fun FeedRepositoryTest(feedRepository: FeedRepository) {
    val feeds1 by feedRepository.feeds1.collectAsState(initial = ArrayList())
    val gson = Gson().newBuilder().setPrettyPrinting().create()

    val coroutine = rememberCoroutineScope()
    Column {
        Row {
            Button(onClick = {
                coroutine.launch {
                    feedRepository.loadFeed(1)
                }
            }) {
                Text(text = "LoadFeed")
            }
            Button(onClick = {
                coroutine.launch {
                    feedRepository.deleteFeedAll()
                }
            }) {
                Text(text = "DeleteFeed")
            }
            Button(onClick = {
                coroutine.launch {
                    feedRepository.addLike(1, 82)
                }
            }) {
                Text(text = "addLike")
            }
            Button(onClick = {
                coroutine.launch {
                    feedRepository.deleteLike(1, 82)
                }
            }) {
                Text(text = "deleteLike")
            }
        }
        LazyColumn(content = {
            items(feeds1.size) {
                Text(text = gson.toJson(feeds1[it]))
            }
        })
    }
}