package com.sarang.torang.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.sarang.torang.api.handle
import com.sarang.torang.data.entity.ReviewAndImageEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun deleteFeedAll()
    suspend fun loadFeed()
    suspend fun loadFeedWithPage(page: Int)
    suspend fun addLike(reviewId: Int)
    suspend fun deleteLike(reviewId: Int)
    suspend fun addFavorite(reviewId: Int)
    suspend fun deleteFavorite(reviewId: Int)
    suspend fun loadUserAllFeedsByReviewId(reviewId: Int)
    suspend fun loadMyAllFeedsByReviewId(reviewId: Int)
    val feeds: Flow<List<ReviewAndImageEntity>>

    /**
     * 리뷰 ID 기준으로 이전 피드는 위로 다음 피드는 아래로 줄 수 있도록
     * @param reviewId 리뷰 id
     */
    fun getMyFeed(reviewId: Int): Flow<List<ReviewAndImageEntity>>
    suspend fun getFeedByReviewId(reviewId: Int): ReviewAndImageEntity
    fun getFeedByRestaurantId(restaurantId: Int): Flow<List<ReviewAndImageEntity>>
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FeedRepositoryTest(feedRepository: FeedRepository) {
    val feeds by feedRepository.feeds.collectAsState(initial = ArrayList())
    val gson = Gson().newBuilder().setPrettyPrinting().create()
    var result by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    var reviewId by remember { mutableStateOf(0) }
    val list by feedRepository.getMyFeed(reviewId).collectAsState(initial = ArrayList())
    Column(
        Modifier
            .fillMaxWidth()
            .height(700.dp)
    ) {
        HorizontalDivider(color = Color.LightGray)
        Text(text = "FeedRepositoryTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Column {
            Text(text = error, color = Color.Red, fontWeight = FontWeight.Bold)
            FlowRow {
                Button(onClick = {
                    coroutine.launch {
                        try {
                            feedRepository.loadFeed()
                        } catch (e: Exception) {
                            error = e.toString()
                        }
                    }
                }) { Text(text = "getFeed") }
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
                Button(onClick = { coroutine.launch { feedRepository.deleteLike(82) } }) {
                    Text(
                        text = "deleteLike"
                    )
                }
                Button(onClick = {
                    reviewId = 370
                }) {
                    Text(text = "GetMyFeed")
                }
            }
            DeleteFeedTest(feedRepository)
            PageFeed(feedRepository)
        }
        LazyColumn(content = {
            items(feeds.size) {
                Text(text = gson.toJson(feeds[it]))
            }
        })
        Text(text = result)
        Text(text = gson.toJson(list))
    }
}

@Composable
fun DeleteFeedTest(feedRepository: FeedRepository) {
    var reviewId by remember { mutableStateOf("10") }
    val coroutine = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = reviewId,
            onValueChange = { reviewId = it },
            label = {
                Text(text = "reviewId")
            })
        Button(onClick = {
            coroutine.launch {
                feedRepository.deleteFeed(reviewId.toInt())
            }
        }) {
            Text(text = "delete")
        }
    }
}

@Composable
fun PageFeed(feedRepository: FeedRepository) {
    var reviewId by remember { mutableStateOf("1") }
    val coroutine = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = reviewId,
            onValueChange = { reviewId = it },
            label = {
                Text(text = "page")
            })
        Button(onClick = {
            coroutine.launch {
                feedRepository.loadFeedWithPage(reviewId.toInt())
            }
        }) {
            Text(text = "getFeed")
        }
    }
}