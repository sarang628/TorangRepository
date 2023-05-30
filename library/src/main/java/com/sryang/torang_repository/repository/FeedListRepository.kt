package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.FavoriteEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LikeEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.StateFlow

interface FeedListRepository {
    // 피드 중앙 리뷰이미지 불러오기
    fun getReviewImages(reviewId: Int): StateFlow<List<ReviewImageEntity>>
    // 피드 리스트 불러오기
    fun getFeed(): StateFlow<List<FeedEntity>>
    // 피드 리스트 갱신하기
    suspend fun loadFeed()
    // 좋아요 처리
    suspend fun like(reviewId: Int)
    // 즐겨찾기 처리
    suspend fun favorite(reviewId: Int)
    // 좋아요 여부
    fun getLike(reviewId: Int): StateFlow<LikeEntity>
    // 즐겨찾기 여부
    fun getFavorite(reviewId: Int): StateFlow<FavoriteEntity>
    // 사용자 정보 로그인 및 메뉴처리
    suspend fun user1(): LoggedInUserEntity?
    // 로그인 여부
    val isLogin: StateFlow<Boolean>
    suspend fun isLogin() : Boolean
}