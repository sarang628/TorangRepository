package com.sarang.torang.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiJoin {
    @FormUrlEncoded
    @POST("checkEmail")
    suspend fun checkEmail(
        @Field("email") email: String,
        @Field("password") password: String,
    ): String

    @FormUrlEncoded
    @POST("confirmCode")
    suspend fun confirmCode(
        @Field("token") token: String,
        @Field("confirmationCode") confirmCode: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Boolean
}