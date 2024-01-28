package com.sarang.torang.repository

import com.sarang.torang.data.entity.FavoriteEntity
import com.sarang.torang.data.entity.LikeEntity
import com.sarang.torang.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

interface FeedListRepository {
    // 피드 중앙 리뷰이미지 불러오기
    fun getReviewImages(reviewId: Int): Flow<List<ReviewImageEntity>>
    // 피드 리스트 갱신하기
    suspend fun loadFeed()
    // 좋아요 처리
    suspend fun like(reviewId: Int)
    // 즐겨찾기 처리
    suspend fun favorite(reviewId: Int)
    // 좋아요 여부
    fun getLike(reviewId: Int): Flow<LikeEntity>
    // 즐겨찾기 여부
    fun getFavorite(reviewId: Int): Flow<FavoriteEntity>
    // 로그인 여부
    val isLogin: Flow<Boolean>
    suspend fun isLogin() : Boolean
}