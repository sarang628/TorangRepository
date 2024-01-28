package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sarang.torang.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PictureDao {
    @Query("select * from ReviewImageEntity Where reviewId = :reviewId")
    fun getFeedImage(reviewId: Int): Flow<List<ReviewImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun insertAll(plantList: List<ReviewImageEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPictures(reviewImages: List<ReviewImageEntity>)

    @Query("delete from ReviewImageEntity Where reviewId = :reviewId")
    suspend fun removePicture(reviewId: Int)

    @Query("DELETE FROM ReviewImageEntity")
    suspend fun deleteAll()
}