package com.sryang.torang_repository.data.remote.response

data class FavoriteResponse(
    val favorite_id: Int,
    val user_id: Int,
    val review_id: Int,
    val create_date: String?
)
