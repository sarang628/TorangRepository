package com.sryang.torang_repository.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteDao {

    @Query("select count(*) from FavoriteEntity where review_id = (:reviewId)")
    suspend fun hasFavorite(reviewId: Int): Int


    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)

    @Query("select * from FavoriteEntity where review_id = (:reviewId)")
    suspend fun getFavorite1(reviewId: Int): FavoriteEntity

    @Insert
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Query("select * from FavoriteEntity where review_id = (:reviewId)")
    fun getFavorite(reviewId: Int): Flow<FavoriteEntity>
}