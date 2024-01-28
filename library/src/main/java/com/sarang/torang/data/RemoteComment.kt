package com.sarang.torang.data

import com.sarang.torang.data.remote.response.RemoteUser

data class RemoteComment(
    val comment_id: Int,
    val review_id: Int,
    val comment: String,
    val user: RemoteUser,
    val create_date: String
)
