package com.sryang.torang_repository.data

data class RemoteComment(
    val comment_id: Int,
    val review_id: Int,
    val comment: String,
    val create_date: String,
    val user_id: Int,
    val user_name: String,
    val profile_pic_url: String
)
