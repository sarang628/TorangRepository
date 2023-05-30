package com.example.torangrepository.data.remote.request

import com.google.gson.annotations.SerializedName

data class RequestGetFeed(
    @SerializedName("user_id") val userId: Int
)
