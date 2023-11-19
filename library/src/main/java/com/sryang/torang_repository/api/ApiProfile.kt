package com.sryang.torang_repository.api

import com.sryang.torang_repository.data.User
import com.sryang.torang_repository.data.remote.response.RemoteFollower
import com.sryang.torang_repository.data.remote.response.RemoteUser
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
    ): User

    @FormUrlEncoded
    @POST("getProfile")
    suspend fun getProfile(
        @Field("user_id") user_id: String
    ): RemoteUser

    @POST("getProfileByToken")
    suspend fun getProfileByToken(
        @Header("authorization") auth: String
    ): RemoteUser

    @POST("follower")
    suspend fun getFollower(
        @Header("authorization") auth: String
    ): List<RemoteFollower>

    @POST("following")
    suspend fun getFollowing(
        @Header("authorization") auth: String
    ): List<RemoteFollower>

    @FormUrlEncoded
    @POST("follow")
    suspend fun follow(
        @Header("authorization") auth: String,
        @Field("user_id") user_id: Int
    ): Boolean

    @FormUrlEncoded
    @POST("unfollow")
    suspend fun unfollow(
        @Header("authorization") auth: String,
        @Field("user_id") user_id: Int
    ): Boolean

    @FormUrlEncoded
    @POST("getProfileWithFollow")
    suspend fun getProfileWithFollow(
        @Header("authorization") auth: String,
        @Field("user_id") user_id: Int
    ): RemoteUser
}