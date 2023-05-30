package com.sryang.torang_repository.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sryang.torang_repository.Alarm
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.AlarmRepository
import com.sryang.torang_repository.services.RestaurantService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepositoryImpl @Inject constructor(
    private val loggedInUserDao: LoggedInUserDao,
    private val restaurantService: RestaurantService, override val isLogin: LiveData<Boolean>
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

    override fun user(): LiveData<LoggedInUserEntity?> {
        return loggedInUserDao.getLoggedInUserEntity()
    }
}