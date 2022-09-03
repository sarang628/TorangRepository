package com.sryang.torang_repository.di.service

import com.sryang.torang_repository.BuildConfig
import com.sryang.torang_repository.di.modules.service.feed.LocalFeedService
import com.sryang.torang_repository.di.modules.service.feed.ProductFeedService
import com.sryang.torang_repository.di.modules.service.feed.TestFeedService
import com.sryang.torang_repository.services.FeedServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.lang.reflect.InvocationTargetException
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FeedServiceModule {

    @Singleton
    @Provides
    fun provideFeedService(
        feedProductFeedService: ProductFeedService,
        localFeedService: LocalFeedService,
        testFeedServices: TestFeedService
    ): FeedServices {
        return when (BuildConfig.feedService) {
            "test" -> testFeedServices
            "local" -> localFeedService.create()
            "real" -> feedProductFeedService.create()
            else
            -> feedProductFeedService.create()
        }
    }
}
