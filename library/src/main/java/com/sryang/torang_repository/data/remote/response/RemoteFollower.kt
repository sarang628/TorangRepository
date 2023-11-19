package com.sryang.torang_repository.data.remote.response

import com.google.gson.annotations.SerializedName

data class RemoteFollower(
    @SerializedName("follwer_id")
    var follwerId: Int,
    @SerializedName("user_name")
    var userName: String,
    @SerializedName("profile_pic_url")
    var profilePicUrl: String,
    var isFollow: Int
)