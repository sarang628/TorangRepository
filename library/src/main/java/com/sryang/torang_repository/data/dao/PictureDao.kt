package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PictureDao {
    @Query("select * from ReviewImageEntity Where reviewId = :reviewId")
    fun getFeedImage(reviewId: Int): Flow<List<ReviewImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plantList: List<ReviewImageEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPictures(reviewImages: List<ReviewImageEntity>)
}