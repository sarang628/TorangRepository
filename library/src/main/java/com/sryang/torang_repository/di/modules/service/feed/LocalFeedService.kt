package com.sryang.torang_repository.di.modules.service.feed

import com.sryang.torang_repository.di.modules.RetrofitModule
import com.sryang.torang_repository.di.modules.TorangOkhttpClient
import com.sryang.torang_repository.services.FeedServices
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 로컬 서버 피드 서비스
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