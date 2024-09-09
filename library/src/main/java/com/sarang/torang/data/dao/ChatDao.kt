package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sarang.torang.data.entity.ChatEntity
import com.sarang.torang.data.entity.ChatParticipantsEntity
import com.sarang.torang.data.entity.ChatRoomEntity
import com.sarang.torang.data.entity.ChatRoomWithParticipantsEntity
import com.sarang.torang.data.entity.ParticipantsWithUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Query(
        """
        SELECT *
        FROM ChatRoomEntity
        ORDER BY createDate DESC
        """
    )
    fun getChatRoom(): Flow<List<ChatRoomWithParticipantsEntity>>

    @Query("SELECT * FROM ChatParticipantsEntity WHERE roomId = :roomId")
    fun getParticipantsWithUsers(roomId: Int): Flow<List<ParticipantsWithUserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParticipats(list: List<ChatParticipantsEntity>)


    @Query(
        """
        SELECT *
        FROM ChatEntity
        WHERE roomId = :roomId
        ORDER BY createDate DESC
        """
    )
    fun getContents(roomId: Int): Flow<List<ChatEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(chatRoomEntity: List<ChatRoomEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllChat(chatRoomEntity: List<ChatEntity>)
}