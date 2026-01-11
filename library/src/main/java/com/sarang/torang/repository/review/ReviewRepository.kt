package com.sarang.torang.repository.review

import com.sarang.torang.data.Feed
import com.sarang.torang.data.ReviewAndImage

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int): List<Feed>

    suspend fun addReview(
        contents: String,
        restaurantId: Int?,
        rating: Float,
        files: List<String>
    ): Feed

    suspend fun updateReview(
        reviewId: Int,
        contents: String,
        restaurantId: Int?,
        rating: Float,
        files: List<String>,
        uploadedImage: List<Int>
    )

    suspend fun getReview(reviewId: Int): ReviewAndImage
}