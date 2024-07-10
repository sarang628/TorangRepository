package com.sarang.torang.repository.review

import com.sarang.torang.data.entity.ReviewAndImageEntity
import com.sarang.torang.data.remote.response.FeedApiModel

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int): List<FeedApiModel>

    suspend fun addReview(
        contents: String,
        restaurantId: Int?,
        rating: Float,
        files: List<String>
    ): FeedApiModel

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