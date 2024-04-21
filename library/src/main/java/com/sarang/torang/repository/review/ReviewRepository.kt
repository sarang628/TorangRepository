package com.sarang.torang.repository.review

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sarang.torang.data.entity.ReviewAndImageEntity
import com.sarang.torang.data.remote.response.RemoteFeed
import com.sarang.torang.repository.review.compose.AddReviewTest
import kotlinx.coroutines.launch

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int): List<RemoteFeed>

    suspend fun addReview(
        contents: String,
        restaurantId: Int?,
        rating: Float,
        files: List<String>
    ): RemoteFeed

    suspend fun updateReview(
        reviewId: Int,
        contents: String,
        restaurantId: Int?,
        rating: Float,
        files: List<String>,
        uploadedImage: List<Int>
    )

    suspend fun getReview(reviewId: Int): ReviewAndImageEntity
}