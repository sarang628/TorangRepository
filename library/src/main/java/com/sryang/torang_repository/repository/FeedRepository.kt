package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_repository.data.remote.response.Response

interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun loadFeed() : List<Feed>
}