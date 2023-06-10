package com.sryang.torang_repository.di

import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.impl.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModules {
    @Binds
    abstract fun provideRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}