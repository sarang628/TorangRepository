package com.sryang.torang_repository.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.sryang.torang_repository.services.RestaurantService
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_core.data.data.Alarm
import com.sryang.torang_repository.repository.AlarmRepository
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepositoryImpl @Inject constructor(
    private val loggedInUserDao: LoggedInUserDao,
    private val restaurantService: RestaurantService
) : AlarmRepository {


    override suspend fun loadAlarm(): ArrayList<Alarm> {
        Logger.d("")
        var userId = 0
        loggedInUserDao.getLoggedInUserEntity1()?.userId?.let {
            userId = it
        }
        Logger.d("getService().getAlarms(user_id = userId)")
        return restaurantService.getAlarms(user_id = userId)
    }

    override suspend fun deleteAlarm() {

    }

    override fun user(): LiveData<LoggedInUserEntity?> {
        return loggedInUserDao.getLoggedInUserEntity()
    }

    /** 로그인 여부 */
    override val isLogin: LiveData<Boolean> = loggedInUserDao.getLoggedInUserEntity().switchMap {
        if (it != null) {
            MutableLiveData(it.userId != 0)
        } else {
            MutableLiveData(false)
        }
    }
}

/**
 * 로그인 테스트용 TestAlarmRepositoryImpl
 * 실제 사용 AlarmRepositoryImpl
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AlarmRepositoryModule {

    @Binds
    //실제 사용
    abstract fun provideAlarmRepository(alarmRepository: AlarmRepositoryImpl): AlarmRepository
    //로그인 테스트
//    abstract fun provideAlarmRepository(alarmRepository: TestAlarmRepositoryImpl): AlarmRepository
}