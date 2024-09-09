package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName

data class ChatUserApiModel(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String,
)
