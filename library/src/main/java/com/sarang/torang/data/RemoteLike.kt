package com.sarang.torang.data

import com.google.gson.annotations.SerializedName

data class RemoteLike(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("review_id")
    val reviewId: Int,
    @SerializedName("like_id")
    val likeId: Int,
    @SerializedName("create_date")
    val createDate: String
)
