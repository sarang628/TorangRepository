package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName

data class RemoteUser(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
    val email: String?,
    @SerializedName("login_platform")
    val loginPlatform: String?,
    @SerializedName("create_date")
    val createDate: String?,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String,
    val post: Int,
    val follower: Int,
    val following: Int,
    val follow: Int
)
