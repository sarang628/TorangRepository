package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sarang.torang.data.RemoteComment

@Entity
data class CommentEntity(
    @PrimaryKey val commentId: Int,
    val userId: Int,
    val profilePicUrl: String,
    val userName: String,
    val comment: String,
    val reviewId: Int,
    val createDate: String,
    val commentLikeId: Int?,
    val commentLikeCount: Int,
    val tagUserId: Int? = null,
    val subCommentCount: Int? = null,
    val parentCommentId: Int? = null,
)

fun List<RemoteComment>.toCommentEntityList(): List<CommentEntity> {
    return this.flatMap { comment ->
        val list = mutableListOf<CommentEntity>()
        list.add(comment.toCommentEntity())
        comment.childComment?.let { list.add(it.toCommentEntity()) }
        list
    }
}

fun RemoteComment.toCommentEntity(): CommentEntity {
    return CommentEntity(
        commentId = this.comment_id,
        comment = this.comment,
        parentCommentId = this.parent_comment_id,
        commentLikeId = this.comment_like_id,
        commentLikeCount = this.comment_like_count,
        subCommentCount = this.sub_comment_count,
        createDate = this.create_date,
        tagUserId = this.tagUser?.userId,
        profilePicUrl = this.user.profilePicUrl,
        reviewId = this.review_id,
        userName = this.user.userName,
        userId = this.user.userId
    )
}