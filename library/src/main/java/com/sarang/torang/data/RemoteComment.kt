package com.sarang.torang.data

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    val parent_comment_id: Int,
    val childComments: RemoteCommentList? = null,
    val childComment: RemoteComment? = null
)

@Composable
fun RemoteComment.ToComposable() {
    Column {
        Text(text = "comment_id: ${comment_id}")
        HorizontalDivider()
        Text(text = "review_id: ${review_id}")
        HorizontalDivider()
        Text(text = "user: ${user}")
        HorizontalDivider()
        Text(text = "comment: ${comment}")
        HorizontalDivider()
        Text(text = "tagUser: ${tagUser}")
        HorizontalDivider()
        Text(text = "parentCommentId: ${parent_comment_id}")
        HorizontalDivider()
        Text(text = "childComments: ${childComments}")
        HorizontalDivider()
        Text(text = "childComment: ${childComment}")
        HorizontalDivider()
    }
}

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
