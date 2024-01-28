package com.sarang.torang.data.remote.response

data class LikeResponse(
    val like_id: Int,
    val user_id: Int,
    val review_id: Int,
    val create_date: String
)
