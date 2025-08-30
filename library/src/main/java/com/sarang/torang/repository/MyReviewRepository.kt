package com.sarang.torang.repository

import com.sarang.torang.data.ModifyFeedData
import com.sarang.torang.core.database.model.feed.FeedEntity
import com.sarang.torang.core.database.model.restaurant.RestaurantEntity
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.core.database.model.image.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

interface MyReviewRepository {
    fun getMyReview(reviewId: Int): Flow<FeedEntity?>
    fun getUploadedPicture(reviewId: Int): Flow<List<ReviewImageEntity>>
    fun userId(): Int
    suspend fun userId1(): Int
    suspend fun uploadReview(review: ReviewAndImageEntity)
    suspend fun modifyReview(review: ReviewAndImageEntity)
    suspend fun modifyReview(review: ModifyFeedData)
    suspend fun getRestaurant(restaurantId: Int): RestaurantEntity? // 식당 ID로 식당 정보 가져오기
}