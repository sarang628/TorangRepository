package com.sarang.torang.repository

import com.sarang.torang.data.RemoteAlarm

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): List<RemoteAlarm>

    suspend fun deleteAlarm()
}