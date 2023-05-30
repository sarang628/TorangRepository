package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.CommentEntity

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
    fun getComments(reviewId: Int): LiveData<List<CommentEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(list: List<CommentEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(commentData: CommentEntity)
}