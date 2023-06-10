package com.sryang.torang_repository.di

import com.sryang.torang_repository.services.RestaurantService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 토랑 서비스
 */
@Singleton
class ProductRestaurantService @Inject constructor(
    private val torangOkHttpClientImpl: com.sryang.torang_repository.di.TorangOkhttpClient,
    private val retrofitModule: com.sryang.torang_repository.di.RetrofitModule
) {
    private var url = "https://www.vrscoo.com:8080/"
    fun create(): RestaurantService {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(
            RestaurantService::class.java
        )
    }
}