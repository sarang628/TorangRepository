package com.sarang.torang.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sarang.torang.data.entity.ChatEntity
import com.sarang.torang.data.entity.ChatRoomEntity
import com.sarang.torang.data.entity.FavoriteEntity
import com.sarang.torang.data.entity.LikeEntity
import com.sarang.torang.data.entity.MyFeedEntity
import com.sarang.torang.data.entity.RestaurantEntity
import com.sarang.torang.data.entity.ReviewAndImageEntity
import com.sarang.torang.data.entity.ReviewImageEntity
import com.sarang.torang.data.entity.UserEntity
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
    fun getChatRoom(): Flow<List<ChatRoomEntity>>

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