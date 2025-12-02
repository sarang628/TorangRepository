package com.sarang.torang.repository

import com.sarang.torang.core.database.model.favorite.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun addFavorite(reviewId: Int)
    /** 즐겨찾기 삭제 */
    suspend fun deleteFavorite(reviewId: Int)
    fun findByReviewIdFlow(reviewId: Int)      : Flow<FavoriteEntity>
}