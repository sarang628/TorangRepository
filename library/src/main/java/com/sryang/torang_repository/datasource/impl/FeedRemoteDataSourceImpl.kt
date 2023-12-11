package com.sryang.torang_repository.datasource.impl

import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedRemoteDataSourceImpl @Inject constructor(
    private val remoteService: ApiFeed
) : FeedRemoteDataSource {
    override suspend fun getFeeds(userId: Int): List<RemoteFeed> {
        val list = remoteService.getFeeds("a")
        return list
    }

    override suspend fun deleteFeed(reviewId: Int) {
        remoteService.deleteReview(reviewId)
    }
}
