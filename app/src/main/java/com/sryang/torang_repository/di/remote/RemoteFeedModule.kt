package com.sryang.torang_repository.di.remote

import com.sryang.torang_repository.di.service.feed.FeedServiceProductImpl
import com.sryang.torang_repository.services.RemoteFeedServices
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Provides
fun provideRemoveFeedService(
    productFeedServiceImpl: FeedServiceProductImpl
): RemoteFeedServices {
    return productFeedServiceImpl.create()
}