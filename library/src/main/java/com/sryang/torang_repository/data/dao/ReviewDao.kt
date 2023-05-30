package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FeedEntity
import kotlinx.coroutines.flow.StateFlow

@Dao
interface ReviewDao {
    @Query("SELECT * FROM FeedEntity")
    fun getReviews(): StateFlow<List<FeedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<FeedEntity>)

    @Query("select * from FeedEntity where review_id = (:reviewId) order by FeedEntity.create_date desc")
    fun getFeedbyReviewId(reviewId: Int): StateFlow<FeedEntity?>
}