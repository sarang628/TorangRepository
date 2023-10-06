package com.sryang.torang_repository.datasource.impl

import com.sryang.torang_repository.data.entity.ReviewDeleteRequestVO
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import com.sryang.torang_repository.api.ApiFeed
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedRemoteDataSourceImpl @Inject constructor(
    private val remoteService: ApiFeed
) : FeedRemoteDataSource {
    override suspend fun getFeeds(hashMap: HashMap<String, String>): List<RemoteFeed> {
        val list = remoteService.getFeeds(1)
        return list
    }

    override suspend fun deleteFeed(reviewId: Int) {
        remoteService.deleteReview(ReviewDeleteRequestVO(reviewId))
    }
}
