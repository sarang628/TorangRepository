package com.sryang.torang_repository.di.service.feed

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.sryang.torang_repository.di.retrofit.RetrofitModule
import com.sryang.torang_repository.di.retrofit.TorangOkHttpClientImpl
import com.sryang.torang_repository.di.retrofit.TorangOkhttpClient
import com.sryang.torang_repository.di.service.restaurant.ProductRestaurantService
import com.sryang.torang_repository.services.FeedServices
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 실서버 피드 서비스
 */
@Singleton
class FeedServiceProductImpl @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://sarang628.iptime.org:8081/"

    //    private var url = "https://www.vrscoo.com:8080/"
    fun create(): FeedServices {
        return retrofitModule
//            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(FeedServices::class.java)
    }
}