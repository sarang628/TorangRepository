package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoggedInUserDao {
    @Query("select * from LoggedInUserEntity")
    fun getLoggedInUserEntity(): Flow<LoggedInUserEntity?>

    @Query("select * from LoggedInUserEntity")
    suspend fun getLoggedInUserEntity1(): LoggedInUserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: LoggedInUserEntity)

    @Query("update LoggedInUserEntity set userName = :name ,profilePicUrl = :url  where constId = 1")
    suspend fun update(name: String, url: String)

    @Query("delete from LoggedInUserEntity where constId = 1")
    suspend fun clear()

    @Query("select COUNT(*) from LoggedInUserEntity")
    fun isLpogin(): Flow<Int>
}