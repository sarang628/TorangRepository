package com.sarang.torang.repository

interface FavoriteRepository {
    suspend fun addFavorite(reviewId: Int)

    /** 즐겨찾기 삭제 */
    suspend fun deleteFavorite(reviewId: Int)
}