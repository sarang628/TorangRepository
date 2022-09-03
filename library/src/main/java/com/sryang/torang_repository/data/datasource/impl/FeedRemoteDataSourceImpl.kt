package com.sryang.torang_repository.data.datasource.impl

import com.sryang.torang_repository.data.datasource.FeedRemoteDataSource
import com.sryang.torang_repository.data.remote.response.FeedResponse
import com.sryang.torang_repository.services.FeedServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedRemoteDataSourceImpl @Inject constructor(
    private val feedServices: FeedServices, // 원격 저장소 주입
) : FeedRemoteDataSource {
    override suspend fun getFeeds(hashMap: HashMap<String, String>): List<FeedResponse> {
        return feedServices.getFeeds(hashMap)
    }
}