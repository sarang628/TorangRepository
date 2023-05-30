package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.StateFlow

@Dao
interface MyReviewDao {
    @Query("select * from ReviewImageEntity where review_id = (:reviewId) order by ReviewImageEntity.create_date desc")
    fun getUploadedImage(reviewId: Int): StateFlow<List<ReviewImageEntity>>


    @Query("select * from FeedEntity where userId = (:userId) and restaurant_id = (:restaurantId) order by FeedEntity.create_date desc")
    fun getMyReviews(userId: Int, restaurantId: Int): StateFlow<List<FeedEntity>>


    /*@Query(
        """
                select FeedData.review_id
                ,picture_url as reviewImageUrl
                ,rating
                ,contents
                ,FeedData.create_date as uploadDate
                ,max(ReviewImage.picture_id) as picture_id
                from FeedData left outer join ReviewImage   
                on FeedData.review_id = ReviewImage.review_id
                and FeedData.user_id = (:userId) and FeedData.restaurant_id = (:restaurantId)
                union
                select FeedData.review_id
                ,picture_url as reviewImageUrl
                ,rating
                ,contents
                ,FeedData.create_date as uploadDate
                ,ReviewImage.picture_id
                from FeedData left outer join ReviewImage   
                on FeedData.review_id = ReviewImage.review_id
                where picture_id is null
                and FeedData.user_id = (:userId) and FeedData.restaurant_id = (:restaurantId)
            """
    )
    fun getMyReviews2(userId: Int, restaurantId: Int): Flow<List<MyReviewItemUiState>>*/
}