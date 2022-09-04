package com.sryang.torang_repository.repository.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sryang.torang_core.data.entity.Alarm
import com.sryang.torang_repository.repository.AlarmRepository
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.services.RestaurantService
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
        Logger.d("getService().getAlarms(user_id = userId)")
        return restaurantService.getAlarms(user_id = 4)
    }

    override suspend fun deleteAlarm() {

    }

    override fun user(): LiveData<LoggedInUserEntity?> {
        return MutableLiveData(LoggedInUserEntity(userId = 4))
    }

    override val isLogin: LiveData<Boolean>
        get() = MutableLiveData(true)
}