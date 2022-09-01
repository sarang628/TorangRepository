package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_core.data.data.Alarm
import com.sryang.torang_repository.data.entity.LoggedInUserEntity

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): ArrayList<Alarm>

    suspend fun deleteAlarm()

    //사용자 로그인상태를 판단하는 데이터
    fun user() : LiveData<LoggedInUserEntity?>
}