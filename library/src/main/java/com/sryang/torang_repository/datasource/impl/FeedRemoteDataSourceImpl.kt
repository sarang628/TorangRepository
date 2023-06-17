package com.sryang.torang_repository.datasource.impl

import com.sryang.torang_repository.data.entity.ReviewDeleteRequestVO
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import com.sryang.torang_repository.services.FeedServices
import javax.inject.Inject
import javax.inject.Singleton

/*
@Singleton
class FeedRemoteDataSourceImpl @Inject constructor(
    private val feedServices: FeedServices, // 원격 저장소 주입
) : FeedRemoteDataSource {
    override suspend fun getFeeds(hashMap: HashMap<String, String>): List<RemoteFeed> {
        val list = feedServices.getFeeds(hashMap)
        return list
    }

    override suspend fun deleteFeed(reviewId: Int) {
        feedServices.deleteReview(ReviewDeleteRequestVO(reviewId))
    }
}*/
