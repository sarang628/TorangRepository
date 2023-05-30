package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.ModifyFeedData
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.StateFlow

interface MyReviewRepository {
    fun getMyReview(reviewId: Int): StateFlow<FeedEntity?>
    fun getUploadedPicture(reviewId: Int): StateFlow<List<ReviewImageEntity>>
    fun userId(): Int
    suspend fun userId1(): Int
    suspend fun uploadReview(review: ReviewAndImageEntity)
    suspend fun modifyReview(review: ReviewAndImageEntity)
    suspend fun modifyReview(review: ModifyFeedData)
    suspend fun getRestaurant(restaurantId: Int): RestaurantEntity? // 식당 ID로 식당 정보 가져오기
}