package com.sryang.torang_repository.repository.impl

import com.sryang.torang_repository.api.ApiAlarm
import com.sryang.torang_repository.data.Alarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepositoryImpl @Inject constructor(
    private val loggedInUserDao: LoggedInUserDao,
    private val apiAlarm: ApiAlarm, override val isLogin: Flow<Boolean>
) : AlarmRepository {


    override suspend fun loadAlarm(): ArrayList<Alarm> {
        var userId = 0
        loggedInUserDao.getLoggedInUserEntity1()?.userId?.let {
            userId = it
        }
        return apiAlarm.getAlarms(user_id = userId)
    }

    override suspend fun deleteAlarm() {

    }
}