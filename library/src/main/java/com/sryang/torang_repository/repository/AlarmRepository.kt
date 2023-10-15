package com.sryang.torang_repository.repository

import com.sryang.torang_repository.api.ApiAlarm
import com.sryang.torang_repository.data.Alarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): ArrayList<Alarm>

    suspend fun deleteAlarm()
}

class AlarmRepositoryTest constructor(
    private val loggedInUserDao: LoggedInUserDao,
    private val apiAlarm: ApiAlarm
) : AlarmRepository {

    override suspend fun loadAlarm(): ArrayList<Alarm> {
        var userId = 0
        loggedInUserDao.getLoggedInUserEntity1()?.userId?.let {
            userId = it
        }
        return apiAlarm.getAlarms(user_id = 4)
    }

    override suspend fun deleteAlarm() {}

    override val isLogin: Flow<Boolean>
        get() = MutableStateFlow(true)
}