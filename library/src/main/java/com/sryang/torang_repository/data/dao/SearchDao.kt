package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sryang.torang_repository.data.entity.SearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {
    @Query("SELECT * FROM SearchEntity order by createDate desc")
    fun getHistoryKeywords(): Flow<List<SearchEntity>>

    @Insert
    suspend fun insertAll(vararg searches: SearchEntity?)

    @Delete
    suspend fun delete(search: SearchEntity?)
}