package com.sryang.torang_repository.di.api

import com.sryang.torang_repository.api.ApiProfile
import com.sryang.torang_repository.di.RetrofitModule
import com.sryang.torang_repository.di.TorangOkhttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiProfileModule {
    @Singleton
    @Provides
    fun provideRemoteFeedService(
        apiProfile: ProductApiProfile
    ): ApiProfile {
        return apiProfile.create()
    }
}

@Singleton
class ProductApiProfile @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://sarang628.iptime.org:8081/"
    fun create(): ApiProfile {
        return retrofitModule
//            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(ApiProfile::class.java)
    }
}