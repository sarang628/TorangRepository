package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName

data class RemoteFollower(
    @SerializedName("follower_id")
    var followerId: Int,
    @SerializedName("user_name")
    var userName: String,
    @SerializedName("profile_pic_url")
    var profilePicUrl: String,
    var isFollow: Int
)