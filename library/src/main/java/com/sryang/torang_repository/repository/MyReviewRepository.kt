package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_core.data.data.ModifyFeedData
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity

interface MyReviewRepository {
    fun getMyReview(reviewId: Int): LiveData<ReviewAndImageEntity?>
    fun getUploadedPicture(reviewId: Int): LiveData<List<ReviewImageEntity>>
    fun userId(): Int
    suspend fun userId1(): Int
    suspend fun uploadReview(review: ReviewAndImageEntity)
    suspend fun modifyReview(review: ReviewAndImageEntity)
    suspend fun modifyReview(review: ModifyFeedData)
    suspend fun getRestaurant(restaurantId: Int): RestaurantEntity? // 식당 ID로 식당 정보 가져오기
}