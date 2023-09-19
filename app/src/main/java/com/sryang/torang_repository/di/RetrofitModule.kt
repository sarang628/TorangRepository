package com.sryang.torang_repository.di

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Hilt를 사용하여 Retrofit을 주입 할 수 있도록 제공
 */
@Singleton
class RetrofitModule @Inject constructor() {
    fun getRetrofit(httpClient: OkHttpClient, API_URL: String): Retrofit {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofit1(): Retrofit {
        return Retrofit.Builder()
            .build()
    }
}