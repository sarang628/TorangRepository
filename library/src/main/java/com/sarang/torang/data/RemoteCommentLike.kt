package com.sarang.torang.data

import com.sarang.torang.data.remote.response.RemoteUser

data class RemoteCommentLike(
    val commentLikeId: Int,
    val userId: Int,
    val commentId: Int
)
