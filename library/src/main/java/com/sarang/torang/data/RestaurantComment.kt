package com.sarang.torang.data

data class RestaurantComment(
    val review_id: Int,
    val user_id: Int,
    val user_name: String,
    val comment: String,
    val create_date: String,
    val profile_pic_url: String
)