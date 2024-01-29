package com.sarang.torang.repository

import com.sarang.torang.data.RemoteAlarm

interface AlarmRepository {
    suspend fun loadAlarm(): List<RemoteAlarm>

    suspend fun deleteAlarm()
}