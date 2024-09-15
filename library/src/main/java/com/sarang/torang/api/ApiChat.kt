package com.sarang.torang.api

import com.sarang.torang.data.remote.response.ChatApiModel
import com.sarang.torang.data.remote.response.ChatRoomApiModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiChat {

    @POST("getChatRoom")
    suspend fun getChatRoom(@Header("authorization") auth: String): List<ChatRoomApiModel>

    @FormUrlEncoded
    @POST("getContents")
    suspend fun getContents(
        @Header("authorization") auth: String,
        @Field("roomId") roomId: Int,
    ): List<ChatApiModel>

    @FormUrlEncoded
    @POST("createChatRoom")
    suspend fun createChatRoom(
        @Header("authorization") auth: String,
        @Field("userId") userId: Int,
    ): ChatRoomApiModel

    @FormUrlEncoded
    @POST("addChat")
    suspend fun addChat(
        @Header("authorization") auth: String,
        @Field("roomId") roomId: Int,
        @Field("message") message: String,
    ): ChatApiModel
}