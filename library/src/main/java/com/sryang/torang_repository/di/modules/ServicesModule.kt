package com.sryang.torang_repository.di.modules

import com.sryang.torang_repository.services.FeedServices
import com.sryang.torang_repository.services.RestaurantService
import com.sryang.torang_repository.test.TestFeedService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 실서버 신고 서비스
 */
@Singleton
class ProductFeedService @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "https://www.vrscoo.com:8080/"
    fun create(): FeedServices {
        return retrofitModule
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(FeedServices::class.java)
    }
}


/**
 * 로컬 서버 신고 서비스
 */
@Singleton
class LocalFeedService @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://10.0.2.2:8080/"
    fun create(): FeedServices {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(
            FeedServices::class.java
        )
    }
}

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
        //return feedProductFeedService.create()
        return testFeedServices
    }
}

/**
 * 토랑 서비스
 */
@Singleton
class ProductRestaurantService @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "https://www.vrscoo.com:8080/"
    fun create(): RestaurantService {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(
            RestaurantService::class.java
        )
    }
}

@InstallIn(SingletonComponent::class)
@Module
class RestaurantServiceModule {

    @Singleton
    @Provides
    fun provideRestaurantService(productRestaurantService: ProductRestaurantService): RestaurantService {
        return productRestaurantService.create()
    }
}
