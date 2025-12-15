package com.sarang.torang.repository

import com.sarang.torang.data.Feed
import com.sarang.torang.data.ModifyFeedData
import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.ReviewAndImage
import com.sarang.torang.data.ReviewImage
import kotlinx.coroutines.flow.Flow

interface MyReviewRepository {
    fun getMyReview(reviewId: Int): Flow<Feed?>
    fun getUploadedPicture(reviewId: Int): Flow<List<ReviewImage>>
    fun userId(): Int
    suspend fun userId1(): Int
    suspend fun uploadReview(review: ReviewAndImage)
    suspend fun modifyReview(review: ReviewAndImage)
    suspend fun modifyReview(review: ModifyFeedData)
    suspend fun getRestaurant(restaurantId: Int): Restaurant? // 식당 ID로 식당 정보 가져오기
}