package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Delete
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
        WHERE reviewId = (:reviewId)
        ORDER BY createDate DESC
        """
    )
    fun getComments(reviewId: Int): Flow<List<CommentEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(list: List<CommentEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(commentData: CommentEntity)

    @Query("DELETE FROM CommentEntity")
    suspend fun clear()
}