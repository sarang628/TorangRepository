package com.sryang.torang_repository.di

import com.sryang.torang_repository.data.AppDatabase
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DaoModules {
    @Provides
    fun provideLoggedInUserDao(appDatabase: AppDatabase): LoggedInUserDao {
        return appDatabase.LoggedInUserDao()
    }

    @Provides
    fun provideFeedDao(appDatabase: AppDatabase): FeedDao {
        return appDatabase.feedDao()
    }
}