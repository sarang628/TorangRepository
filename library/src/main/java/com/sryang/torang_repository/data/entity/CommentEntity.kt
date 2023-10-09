package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Objects

@Entity
data class CommentEntity(
    @PrimaryKey val commentId: Int,
    val userId: Int,
    val profilePicUrl: String,
    val userName: String,
    val comment: String,
    val reviewId: Int,
    val createDate: String
) {
    companion object {
        fun parse(list: String): List<CommentEntity> {
            val commentList = ArrayList<CommentEntity>()
            for (comment in list) {
//                commentList.add(parse(comment))
            }
            return commentList
        }

        /*fun parse(comment: Comment): CommentEntity {
            return CommentEntity(
                commentId = comment.comment_id,
                userId = comment.user.userId,
                userName = comment.user.userName,
                comment = comment.comment,
                reviewId = comment.review_id,
                createDate = comment.createDate,
                profilePicUrl = comment.user.profilePicUrl
            )
        }*/
    }
}
