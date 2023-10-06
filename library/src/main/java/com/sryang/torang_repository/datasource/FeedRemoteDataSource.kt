package com.sryang.torang_repository.datasource

import com.sryang.torang_repository.data.remote.response.RemoteFeed

interface FeedRemoteDataSource {
    suspend fun getFeeds(userId: Int): List<RemoteFeed>
    suspend fun deleteFeed(reviewId: Int)
}