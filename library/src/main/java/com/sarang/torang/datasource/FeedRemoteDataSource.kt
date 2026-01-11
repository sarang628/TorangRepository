package com.sarang.torang.datasource

import com.sarang.torang.data.Feed

interface FeedRemoteDataSource {
    suspend fun getFeeds(userId: Int): List<Feed>
    suspend fun deleteFeed(reviewId: Int)
}