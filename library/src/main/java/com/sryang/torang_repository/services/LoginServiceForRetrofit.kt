package com.sryang.torang_repository.services

import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Filter
import retrofit2.Response
import retrofit2.http.*

interface LoginServiceForRetrofit {
    @FormUrlEncoded
    @POST("emailLogin")
    suspend fun emailLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResult>

    @POST("join")
    suspend fun join(@Body filter: Filter): ArrayList<Restaurant>
}