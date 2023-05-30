package com.sryang.torang_repository.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.entity.*

interface FeedListRepository {
    // 피드 중앙 리뷰이미지 불러오기
    fun getReviewImages(reviewId: Int): LiveData<List<ReviewImageEntity>>
    // 피드 리스트 불러오기
    fun getFeed(): LiveData<List<FeedEntity>>
    // 피드 리스트 갱신하기
    suspend fun loadFeed()
    // 좋아요 처리
    suspend fun like(reviewId: Int)
    // 즐겨찾기 처리
    suspend fun favorite(reviewId: Int)
    // 좋아요 여부
    fun getLike(reviewId: Int): LiveData<LikeEntity>
    // 즐겨찾기 여부
    fun getFavorite(reviewId: Int): LiveData<FavoriteEntity>
    // 사용자 정보 로그인 및 메뉴처리
    suspend fun user1(): LoggedInUserEntity?
    // 로그인 여부
    val isLogin: LiveData<Boolean>
    suspend fun isLogin() : Boolean
}