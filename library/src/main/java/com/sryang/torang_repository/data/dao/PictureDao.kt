package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.ReviewImageEntity

@Dao
interface PictureDao {
    @Query("select * from ReviewImageEntity Where review_id = :reviewId")
    fun getFeedImage(reviewId: Int): LiveData<List<ReviewImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plantList: List<ReviewImageEntity>)
}