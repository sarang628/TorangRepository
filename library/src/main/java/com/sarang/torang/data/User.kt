package com.sarang.torang.data

data class User(
    val userId: Int,
    val userName: String,
    val email: String?,
    val loginPlatform: String?,
    val createDate: String?,
    val profilePicUrl: String?
)
