package com.sarang.torang.data.remote.response

data class ChatApiModel(
    val uuid: String,
    val roomId: Int,
    val userId: Int,
    val message: String,
    val createDate: String,
)
