package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.MenuEntity

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuEntity")
    fun getReviews(): LiveData<List<MenuEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<MenuEntity>)
}