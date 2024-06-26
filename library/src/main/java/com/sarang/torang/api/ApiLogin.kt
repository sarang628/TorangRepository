package com.sarang.torang.api

import com.sarang.torang.data.User
import com.sarang.torang.data.remote.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiLogin {
    @FormUrlEncoded
    @POST("emailLogin")
    suspend fun emailLogin(
        @Field("email") email: String,
        @Field("password") password: String,
    ): LoginResponse

    @FormUrlEncoded
    @POST("facebook_login")
    suspend fun facebook_login(@Field("accessToken") accessToken: String): Response<User>

    @POST("sessionCheck")
    suspend fun sessionCheck(@Header("authorization") auth: String): Boolean
}