package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.MenuEntity
import kotlinx.coroutines.flow.StateFlow

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuEntity")
    fun getReviews(): StateFlow<List<MenuEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<MenuEntity>)
}