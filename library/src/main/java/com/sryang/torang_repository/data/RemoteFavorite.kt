package com.sryang.torang_repository.data

data class RemoteFavorite(
    val favorite_id: Int,
    val user_id: Int,
    val review_id: Int,
    val create_date: String?
)
