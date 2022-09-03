package com.sryang.torang_repository.data.datasource

import com.sryang.torang_core.data.data.FeedResponse
import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_repository.data.remote.RemoteFeed
import com.sryang.torang_repository.data.remote.response.Response

interface FeedRemoteDataSource {
    suspend fun getFeeds(hashMap: HashMap<String, String>): List<FeedResponse>
}