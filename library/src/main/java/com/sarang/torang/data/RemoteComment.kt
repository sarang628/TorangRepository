package com.sarang.torang.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Text(text = "parentCommentId: ${parentCommentId}")
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
