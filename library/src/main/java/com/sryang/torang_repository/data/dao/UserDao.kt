package com.sryang.torang_repository.data.dao

import androidx.room.*
import com.sryang.torang_repository.data.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): Flow<List<UserEntity>>

    @Query("SELECT * FROM UserEntity WHERE userId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun insertAll(users: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Query("select * from UserEntity where userId = (:userId)")
    fun getUser(userId: Int): Flow<UserEntity>

    @Query("update UserEntity set userName = :userName ,profilePicUrl = :profilePicUrl  where userId = :userId")
    suspend fun updateUser(userId: Int, userName: String, profilePicUrl: String)
}