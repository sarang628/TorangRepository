package com.sryang.torang_core.repository

import com.sryang.torang_core.data.remote.RemoteFeed

interface FeedRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
    suspend fun loadFeed() : ArrayList<RemoteFeed>
}