package com.sarang.torang.data.remote.request

import com.google.gson.annotations.SerializedName

data class ReviewDeleteRequestVO(
    @SerializedName("review_id")
    val reviewId: Int
)