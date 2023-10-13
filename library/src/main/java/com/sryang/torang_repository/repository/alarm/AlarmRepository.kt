package com.sryang.torang_repository.repository.alarm

import com.sryang.torang_repository.api.ApiAlarm
import com.sryang.torang_repository.data.Alarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.login.LoginCheckableRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): ArrayList<Alarm>

    suspend fun deleteAlarm()

    //사용자 로그인상태를 판단하는 데이터
    fun user(): Flow<LoggedInUserEntity?>
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

    override suspend fun deleteAlarm() {

    }

    override fun user(): Flow<LoggedInUserEntity?> {
        return MutableStateFlow(LoggedInUserEntity(userId = 4))
    }

    override val isLogin: Flow<Boolean>
        get() = MutableStateFlow(true)
}