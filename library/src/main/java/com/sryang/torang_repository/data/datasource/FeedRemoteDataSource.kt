package com.sryang.torang_repository.data.datasource

import com.sryang.torang_repository.data.remote.response.FeedResponse

interface FeedRemoteDataSource {
    suspend fun getFeeds(hashMap: HashMap<String, String>): List<FeedResponse>
}