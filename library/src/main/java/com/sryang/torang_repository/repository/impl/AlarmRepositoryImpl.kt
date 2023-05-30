package com.sryang.torang_repository.repository.impl

import com.sryang.torang_repository.Alarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.AlarmRepository
import com.sryang.torang_repository.services.RestaurantService
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepositoryImpl @Inject constructor(
    private val loggedInUserDao: LoggedInUserDao,
    private val restaurantService: RestaurantService, override val isLogin: StateFlow<Boolean>
) : AlarmRepository {


    override suspend fun loadAlarm(): ArrayList<Alarm> {
        var userId = 0
        loggedInUserDao.getLoggedInUserEntity1()?.userId?.let {
            userId = it
        }
        return restaurantService.getAlarms(user_id = userId)
    }

    override suspend fun deleteAlarm() {

    }

    override fun user(): StateFlow<LoggedInUserEntity?> {
        return loggedInUserDao.getLoggedInUserEntity()
    }
}