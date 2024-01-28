package com.sarang.torang.datasource

import com.sarang.torang.data.remote.response.RemoteFeed

interface FeedRemoteDataSource {
    suspend fun getFeeds(userId: Int): List<RemoteFeed>
    suspend fun deleteFeed(reviewId: Int)
}