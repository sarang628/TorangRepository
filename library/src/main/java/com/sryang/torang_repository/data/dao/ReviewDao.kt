package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FeedEntity

@Dao
interface ReviewDao {
    @Query("SELECT * FROM FeedEntity")
    fun getReviews(): LiveData<List<FeedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<FeedEntity>)

    @Query("select * from FeedEntity where review_id = (:reviewId) order by FeedEntity.create_date desc")
    fun getFeedbyReviewId(reviewId: Int): LiveData<FeedEntity?>
}