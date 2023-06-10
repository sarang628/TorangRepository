package com.sryang.torang_repository.di

import com.sryang.torang_repository.di.retrofit.RetrofitModule
import com.sryang.torang_repository.services.FeedServices
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 로컬 서버 피드 서비스
 */
@Singleton
class LocalFeedServiceImpl @Inject constructor(
    private val torangOkHttpClientImpl: com.sryang.torang_repository.di.TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://10.0.2.2:8080/"
    fun create(): FeedServices {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(
            FeedServices::class.java
        )
    }
}
