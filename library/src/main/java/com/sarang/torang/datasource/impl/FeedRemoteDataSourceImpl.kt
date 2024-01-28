package com.sarang.torang.datasource.impl

import com.sarang.torang.api.ApiFeed
import com.sarang.torang.data.remote.response.RemoteFeed
import com.sarang.torang.datasource.FeedRemoteDataSource
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
