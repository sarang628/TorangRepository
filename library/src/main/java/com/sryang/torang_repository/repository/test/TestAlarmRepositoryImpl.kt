package com.sryang.torang_repository.repository.test

import com.sryang.torang_repository.Alarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.AlarmRepository
import com.sryang.torang_repository.services.RestaurantService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TestAlarmRepositoryImpl @Inject constructor(
    private val loggedInUserDao: LoggedInUserDao,
    private val restaurantService: RestaurantService
) : AlarmRepository {

    override suspend fun loadAlarm(): ArrayList<Alarm> {
        var userId = 0
        loggedInUserDao.getLoggedInUserEntity1()?.userId?.let {
            userId = it
        }
        return restaurantService.getAlarms(user_id = 4)
    }

    override suspend fun deleteAlarm() {

    }

    override fun user(): Flow<LoggedInUserEntity?> {
        return MutableStateFlow(LoggedInUserEntity(userId = 4))
    }

    override val isLogin: Flow<Boolean>
        get() = MutableStateFlow(true)
}