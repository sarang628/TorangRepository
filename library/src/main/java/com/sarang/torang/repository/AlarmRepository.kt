package com.sarang.torang.repository

import com.sarang.torang.data.remote.response.AlarmAlarmModel

interface AlarmRepository {
    suspend fun loadAlarm(): List<AlarmAlarmModel>

    suspend fun deleteAlarm()
}