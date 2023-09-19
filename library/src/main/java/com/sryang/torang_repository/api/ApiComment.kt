package com.sryang.torang_repository.api

import com.sryang.torang_repository.data.Comment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiComment {
    @POST("addComment")
    suspend fun addComment(@Body comment: Comment): Comment

    @POST("modifyComment")
    suspend fun modifyComment(@Body comment: Comment): Call<Comment>

    @POST("deleteComment")
    suspend fun deleteComment(@Body comment: Comment): Call<Comment>

    @FormUrlEncoded
    @POST("getComments")
    suspend fun getComments(@Field("review_id") review_id: String): ArrayList<Comment>
}