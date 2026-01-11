package com.sarang.torang.repository.comment

import com.sarang.torang.data.Comment
import com.sarang.torang.data.CommentList
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    /**
     * Comment 가져오기
     * @param reviewId
     */
    suspend fun getComment(reviewId: Int): CommentList

    /**
     * Comment 댓글 가져오기
     * @param parentCommentId
     */
    suspend fun getSubComment(parentCommentId: Int): List<Comment>

    /**
     * Comment 삭제하기
     * @param commentId
     */
    suspend fun deleteComment(commentId: Int)

    /**
     * @param onLocalUpdated 로컬 DB에 우선 insert하고 callback. 화면을 최상단으로 올리기전에 DB에 insert가 먼저 되어야 해서
     */
    suspend fun addComment(reviewId: Int, comment: String, onLocalUpdated: () -> Unit)

    /**
     * 댓글 추가하기
     * @param reviewId 리뷰id
     * @param comment 코멘트
     * @param parentCommentId 댓글
     */
    suspend fun addReply(reviewId: Int, comment: String, parentCommentId: Int, onLocalUpdated: () -> Unit)
    suspend fun getCommentsWithOneReply(reviewId: Int): CommentList
    suspend fun getSubComments(commentId: Int): List<Comment>
    fun getCommentsFlow(reviewId: Int): Flow<List<Comment>>
    suspend fun clear()
    suspend fun loadMoreReply(commentId: Int)
}