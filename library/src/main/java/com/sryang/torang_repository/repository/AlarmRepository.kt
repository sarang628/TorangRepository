package com.sryang.torang_repository.repository

import com.sryang.torang_repository.Alarm
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.flow.Flow

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): ArrayList<Alarm>

    suspend fun deleteAlarm()

    //사용자 로그인상태를 판단하는 데이터
    fun user() : Flow<LoggedInUserEntity?>
}