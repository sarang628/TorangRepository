package com.sryang.torang_repository.data.remote.response

import com.google.gson.annotations.SerializedName

data class RemoteUser(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("login_platform")
    val loginPlatform: String?,
    @SerializedName("create_date")
    val createDate: String?,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String?,
    @SerializedName("review_count")
    val reviewCount: Int?,
    @SerializedName("followers")
    val followers: Int?,
    @SerializedName("following")
    val following: Int?
)
