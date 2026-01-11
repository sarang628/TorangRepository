package com.sarang.torang.repository

import com.sarang.torang.data.Alarm

interface AlarmRepository {
    suspend fun loadAlarm(): List<Alarm>

    suspend fun deleteAlarm()
}