package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sryang.torang_repository.data.entity.SearchEntity

@Dao
interface SearchDao {
    @Query("SELECT * FROM SearchEntity order by createDate desc")
    fun getHistoryKeywords(): LiveData<List<SearchEntity>>

    @Insert
    suspend fun insertAll(vararg searches: SearchEntity?)

    @Delete
    suspend fun delete(search: SearchEntity?)
}