package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.torang_core.data.model.Comment

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
        fun parse(list: ArrayList<Comment>): ArrayList<CommentEntity> {
            val commentList = ArrayList<CommentEntity>()
            for (comment in list) {
                commentList.add(parse(comment))
            }
            return commentList
        }

        fun parse(comment: Comment): CommentEntity {
            return CommentEntity(
                commentId = comment.comment_id,
                userId = if (comment.user == null) 0 else comment.user!!.userId,
                userName = if (comment.user == null || comment.user!!.userName == null) "" else comment.user!!.userName!!,
                comment = if (comment.comment == null) "" else comment.comment!!,
                reviewId = comment.review_id,
                createDate = if (comment.createDate == null) "" else comment.createDate!!,
                profilePicUrl = if (comment.user == null || comment.user!!.profile_pic_url == null) "" else comment.user!!.profile_pic_url!!
            )
        }
    }
}
