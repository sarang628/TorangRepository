package com.sarang.torang.repository

import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList

interface CommentRepository {
    suspend fun getComment(reviewId: Int): RemoteCommentList
    suspend fun deleteComment(commentId: Int)
    suspend fun addComment(reviewId: Int, comment: String): RemoteComment
}