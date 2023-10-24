package com.sryang.torang_repository.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.google.gson.Gson
import com.sryang.torang_repository.api.handle
import com.sryang.torang_repository.data.RemoteComment
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun deleteFeedAll()
    suspend fun loadFeed()
    suspend fun addLike(reviewId: Int)
    suspend fun deleteLike(reviewId: Int)
    suspend fun addFavorite(reviewId: Int)
    suspend fun deleteFavorite(reviewId: Int)
    suspend fun getComment(auth: String, reviewId: Int): List<RemoteComment>
    suspend fun deleteComment(commentId: Int)
    suspend fun addComment(reviewId: Int, comment: String)

    val feeds: Flow<List<ReviewAndImageEntity>>
}

@Composable
fun FeedRepositoryTest(feedRepository: FeedRepository) {
    val feeds by feedRepository.feeds.collectAsState(initial = ArrayList())
    val gson = Gson().newBuilder().setPrettyPrinting().create()
    var result by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    Column {
        Column {
            Text(text = error, color = Color.Red, fontWeight = FontWeight.Bold)
            Row {
                Button(onClick = { coroutine.launch { feedRepository.loadFeed() } }) { Text(text = "getFeed") }
                Button(onClick = { coroutine.launch { feedRepository.deleteFeedAll() } }) {
                    Text(
                        text = "delFeed"
                    )
                }
                Button(onClick = {
                    coroutine.launch {
                        try {
                            feedRepository.addLike(82)
                        } catch (e: Exception) {
                            error = e.handle()
                        }
                    }
                }) { Text(text = "addLike") }
                Button(onClick = { coroutine.launch { feedRepository.deleteLike(82) } }) {
                    Text(
                        text = "delLike"
                    )
                }
            }
            Row {
                Button(onClick = {
                    coroutine.launch {
                        try {
                            feedRepository.addFavorite(82)
                        } catch (e: Exception) {
                            error = e.handle()
                        }
                    }
                }) {
                    Text(
                        text = "addFav"
                    )
                }
                Button(onClick = {
                    coroutine.launch {
                        feedRepository.deleteFavorite(82)
                    }
                }) { Text(text = "delFav") }
                Button(onClick = {
                    coroutine.launch {
                        result = feedRepository.getComment("", 82).toString()
                    }
                }) { Text(text = "getComment") }
                Button(onClick = { coroutine.launch { feedRepository.deleteLike(82) } }) {
                    Text(
                        text = "deleteLike"
                    )
                }
            }
        }
        LazyColumn(content = {
            items(feeds.size) {
                Text(text = gson.toJson(feeds[it]))
            }
        })
        Text(text = result)
    }
}