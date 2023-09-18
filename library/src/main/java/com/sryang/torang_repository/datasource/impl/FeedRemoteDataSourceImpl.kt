package com.sryang.torang_repository.datasource.impl

import com.sryang.torang_repository.data.entity.ReviewDeleteRequestVO
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import com.sryang.torang_repository.services.RemoteFeedServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedRemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteFeedServices
) : FeedRemoteDataSource {
    override suspend fun getFeeds(hashMap: HashMap<String, String>): List<RemoteFeed> {
        val list = remoteService.getFeeds(hashMap)
        return list
    }

    override suspend fun deleteFeed(reviewId: Int) {
        remoteService.deleteReview(ReviewDeleteRequestVO(reviewId))
    }
}
