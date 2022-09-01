package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.AlarmAndUserEntity
import com.sryang.torang_repository.data.entity.AlarmEntity

@Dao
interface AlarmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarms(users: List<AlarmEntity>)

    @Query("select * from AlarmEntity order by AlarmEntity.create_date desc")
    fun getAllAlarmData(): LiveData<List<AlarmAndUserEntity>>
}