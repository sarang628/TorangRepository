package com.sryang.torang_repository.services

import com.google.gson.JsonObject
import com.sryang.torang_repository.data.Review
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface RemoteReviewService {
    @FormUrlEncoded
    @POST("getReviews")
    suspend fun getReviews(@FieldMap params: Map<String, String>): ArrayList<Review>

    @FormUrlEncoded
    @POST("getMyReview")
    suspend fun getMyReview(@FieldMap params: Map<String, String>): Call<Review>

    @Multipart
    @POST("addReview")
    suspend fun addReview(@PartMap params: HashMap<String, RequestBody>): JsonObject

    @POST("updateReview")
    suspend fun updateReview(@Body reviewBody: Review): Call<Review>

    @POST("deleteReview")
    suspend fun deleteReview(@Body review: Review): Review

    @Multipart
    @POST("updateReview")
    suspend fun updateReview(
        @PartMap params: HashMap<String, RequestBody>,
        @Part pictures: ArrayList<MultipartBody.Part>
    ): Review

    @FormUrlEncoded
    @POST("getMyReviews")
    suspend fun getMyReviews(@FieldMap params: Map<String, String>): ArrayList<Review>
}