package com.sarang.torang.data

import com.google.gson.annotations.SerializedName

data class RemoteComment(
    val comment_id: Int,
    val review_id: Int,
    val comment: String,
    val user: RemoteCommentUser,
    val create_date: String,
    val comment_like_id: Int?,
    val comment_like_count: Int,
    val tagUser: RemoteTagCommentUser? = null,
    val sub_comment_count: Int,
    val parentCommentId: Int,
    val childComment: RemoteCommentList? = null
)

data class RemoteCommentUser(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
    val email: String?,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String
)

data class RemoteTagCommentUser(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
)
