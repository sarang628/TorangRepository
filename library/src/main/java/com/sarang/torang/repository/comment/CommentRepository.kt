package com.sarang.torang.repository.comment

import com.sarang.torang.data.remote.response.RemoteComment
import com.sarang.torang.data.remote.response.CommentListApiModel
import com.sarang.torang.data.entity.CommentEntity
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    /**
     * Comment 가져오기
     * @param reviewId
     */
    suspend fun getComment(reviewId: Int): CommentListApiModel

    /**
     * Comment 댓글 가져오기
     * @param parentCommentId
     */
    suspend fun getSubComment(parentCommentId: Int): List<RemoteComment>

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
    suspend fun getCommentsWithOneReply(reviewId: Int): CommentListApiModel
    suspend fun getSubComments(commentId: Int): List<RemoteComment>
    fun getCommentsFlow(reviewId: Int): Flow<List<CommentEntity>>
    suspend fun clear()
    suspend fun loadMoreReply(commentId: Int)
}