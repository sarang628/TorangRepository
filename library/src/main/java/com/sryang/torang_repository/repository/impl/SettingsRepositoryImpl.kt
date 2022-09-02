package com.sryang.torang_repository.repository.impl

import com.sryang.torang_repository.repository.SettingsRepository
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepositoryImpl @Inject constructor(
    private val loggedInUserDao: LoggedInUserDao
) :
    SettingsRepository {
    override suspend fun logout() {
        loggedInUserDao.clear()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingRepositoryModule {
    @Binds
    abstract fun provideSettingRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository
}