package com.sarang.torang.api

import com.sarang.torang.data.Filter
import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.User
import com.sarang.torang.data.remote.response.LoginResponse
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

    @FormUrlEncoded
    @POST("checkEmail")
    suspend fun checkEmail(
        @Field("email") email: String,
        @Field("password") password: String
    ): String

    @FormUrlEncoded
    @POST("confirmCode")
    suspend fun confirmCode(
        @Field("token") token: String,
        @Field("confirmationCode") confirmCode: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Boolean
}