package com.sarang.torang.api

import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiReport
{
    @FormUrlEncoded
    @POST("reportReason")
    suspend fun reportReason(
        @Field("reviewId") reviewId: Int,
        @Field("reason") reason: String
    ): Boolean

    @FormUrlEncoded
    @POST("reportAfterSupport")
    suspend fun reportAfterSupport(@FieldMap params: Map<String, String>): Boolean

    @FormUrlEncoded
    @POST("hasFeed")
    suspend fun hasFeed(@Field("reviewId") reviewId: Int): Boolean
}