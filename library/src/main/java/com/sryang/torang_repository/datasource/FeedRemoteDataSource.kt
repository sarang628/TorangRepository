package com.sryang.torang_repository.datasource

import com.sryang.torang_repository.data.remote.response.RemoteFeed

interface FeedRemoteDataSource {
    suspend fun getFeeds(hashMap: HashMap<String, String>): List<RemoteFeed>
    suspend fun deleteFeed(reviewId: Int)
}