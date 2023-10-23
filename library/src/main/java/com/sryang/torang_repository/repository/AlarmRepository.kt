package com.sryang.torang_repository.repository

import com.sryang.torang_repository.api.ApiAlarm
import com.sryang.torang_repository.data.RemoteAlarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): List<RemoteAlarm>

    suspend fun deleteAlarm()
}