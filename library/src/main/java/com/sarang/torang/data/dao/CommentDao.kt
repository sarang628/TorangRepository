package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
}