package com.sryang.torang_repository.services

import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ReportService {
    @FormUrlEncoded
    @POST("reportReason")
    suspend fun reportReason(@FieldMap params: Map<String, String>): Boolean

    @FormUrlEncoded
    @POST("reportAfterSupport")
    suspend fun reportAfterSupport(@FieldMap params: Map<String, String>): Boolean

    @FormUrlEncoded
    @POST("hasFeed")
    suspend fun hasFeed(@FieldMap params: Map<String, String>): Boolean
}