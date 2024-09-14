package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
    fun getParticipantsWithUsersFlow(roomId: Int): Flow<List<ParticipantsWithUserEntity>?>

    @Query("SELECT * FROM ChatParticipantsEntity WHERE roomId = :roomId")
    suspend fun getParticipantsWithUsers(roomId: Int): List<ParticipantsWithUserEntity>?

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

    @Query(
        """
        Delete from ChatRoomEntity
    """
    )
    suspend fun delAllChatRoom()

    @Query(
        """
        Delete from ChatParticipantsEntity
    """
    )
    suspend fun delAllParticipants()

    @Query(
        """
        SELECT c.*, (select count(*) from ChatParticipantsEntity where roomId = c.roomId) count
        FROM ChatRoomEntity c, ChatParticipantsEntity p
        Where 1=1
        and c.roomId = p.roomId
        and p.userId = :userId
        and count = 2
        ORDER BY createDate DESC
        """
    )
    suspend fun getChatRoomByUserId(userId: Int): ChatRoomWithParticipantsEntity?
}