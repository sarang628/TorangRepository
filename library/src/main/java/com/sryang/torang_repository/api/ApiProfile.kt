package com.sryang.torang_repository.api

import com.sryang.torang_repository.data.User
import com.sryang.torang_repository.data.remote.response.LoginResult
import com.sryang.torang_repository.data.remote.response.RemoteUser
import com.sryang.torang_repository.data.remote.response.Response
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface ApiProfile {
    @Multipart
    @POST("updateProfile")
    suspend fun updateProfile(
        @Header("authorization") auth: String,
        @PartMap params: HashMap<String, RequestBody>,
        @Part pictures: ArrayList<MultipartBody.Part>
    ): Response<User>

    @FormUrlEncoded
    @POST("getProfile")
    suspend fun getProfile(
        @Field("user_id") user_id: String
    ): retrofit2.Response<RemoteUser>

    @POST("getProfileByToken")
    suspend fun getProfileByToken(
        @Header("authorization") auth: String
    ): retrofit2.Response<RemoteUser>
}