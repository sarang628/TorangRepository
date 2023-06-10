package com.sryang.torang_repository.repository.feed

import com.sryang.torang_repository.data.Feed


interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun loadFeed() : List<Feed>
}