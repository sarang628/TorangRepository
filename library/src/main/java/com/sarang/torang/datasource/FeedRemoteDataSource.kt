package com.sarang.torang.datasource

import com.sarang.torang.data.remote.response.FeedApiModel

interface FeedRemoteDataSource {
    suspend fun getFeeds(userId: Int): List<FeedApiModel>
    suspend fun deleteFeed(reviewId: Int)
}