package com.sryang.torang_repository.data.entity

import com.google.gson.annotations.SerializedName

data class ReviewDeleteRequestVO(
    @SerializedName("review_id")
    val reviewId: Int
)