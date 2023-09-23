package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {
    @Query("SELECT * FROM FeedEntity")
    fun getReviews(): Flow<List<FeedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<FeedEntity>)

    @Query("select * from FeedEntity where reviewId = (:reviewId) order by FeedEntity.createDate desc")
    fun getFeedbyReviewId(reviewId: Int): Flow<FeedEntity?>
}