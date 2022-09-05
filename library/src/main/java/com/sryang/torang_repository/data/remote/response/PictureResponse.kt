package com.sryang.torang_repository.data.remote.response

data class PictureResponse(
    val picture_id: Int,
    val restaurant_id: Int,
    val user_id: Int,
    val review_id: Int,
    val picture_url: String,
    val create_date: String,
    val menu_id: Int,
    val menu: String
)
