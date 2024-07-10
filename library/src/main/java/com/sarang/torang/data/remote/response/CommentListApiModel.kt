package com.sarang.torang.data.remote.response

data class CommentListApiModel(
    val profilePicUrl: String,
    val list: List<RemoteComment>
)
