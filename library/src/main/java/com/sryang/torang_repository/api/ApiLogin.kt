package com.sryang.torang_repository.api

import com.sryang.torang_repository.data.Filter
import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.User
import com.sryang.torang_repository.data.remote.response.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiLogin {
    @FormUrlEncoded
    @POST("emailLogin")
    suspend fun emailLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @POST("join")
    suspend fun join(@Body filter: Filter): Response<ArrayList<Restaurant>>

    @FormUrlEncoded
    @POST("facebook_login")
    suspend fun facebook_login(@Field("accessToken") accessToken: String): Response<User>

    @POST("sessionCheck")
    suspend fun sessionCheck(@Header("authorization") auth: String): Boolean
}