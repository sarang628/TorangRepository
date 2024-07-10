package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName

data class LikeApiModel(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("review_id")
    val reviewId: Int,
    @SerializedName("like_id")
    val likeId: Int,
    @SerializedName("create_date")
    val createDate: String
)
