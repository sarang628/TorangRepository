package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sarang.torang.data.entity.CommentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {
    @Query(
        """
        SELECT *
        FROM CommentEntity
        WHERE 1=1
        and reviewId = (:reviewId)
        and (parentCommentId == null or parentCommentId == 0)
        ORDER BY createDate DESC
        """
    )
    fun getComments(reviewId: Int): Flow<List<CommentEntity>>

    @Query(
        """
        SELECT *
        FROM CommentEntity
        WHERE 1=1
        and parentCommentId = (:commentId)
        ORDER BY createDate DESC
        """
    )
    suspend fun getReply(commentId: Int): List<CommentEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(list: List<CommentEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(commentData: CommentEntity)

    @Query("DELETE FROM CommentEntity")
    suspend fun clear()

    @Query(
        """
        UPDATE commententity SET commentId = (:commentId) 
                            and userId = (:userId)
                            and profilePicUrl = (:profilePicUrl)
                            and userName = (:userName)
                            and comment = (:comment)
                            and reviewId = (:reviewId)
                            and createDate = (:createDate)
                            and commentLikeId = (:commentLikeId)
                            and commentLikeCount = (:commentLikeCount)
                            and tagUserId = (:tagUserId)
                            and subCommentCount = (:subCommentCount)
                            and parentCommentId = (:parentCommentId)
                            WHERE commentId = (:updateId)
    """
    )
    fun update(
        updateId: Int = Integer.MAX_VALUE,
        commentId: Int,
        userId: Int,
        profilePicUrl: String,
        userName: String,
        comment: String,
        reviewId: Int,
        createDate: String,
        commentLikeId: Int? = null,
        commentLikeCount: Int = 0,
        tagUserId: Int? = null,
        subCommentCount: Int? = null,
        parentCommentId: Int? = null,
    )
}