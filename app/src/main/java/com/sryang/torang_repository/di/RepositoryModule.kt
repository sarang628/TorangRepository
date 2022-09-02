package com.sryang.torang_repository.di

import com.sryang.torang_core.repository.FeedRepository
import com.sryang.torang_core.repository.LoginRepository
import com.sryang.torang_core.repository.MyReviewsRepository
import com.sryang.torang_repository.repository.impl.FeedRepositoryImpl
import com.sryang.torang_repository.repository.impl.LoginRepositoryImpl
import com.sryang.torang_repository.repository.impl.MyReviewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideMyReviewsRepository(
//        testMyReviewsRepository: MyReviewsRepositoryWithData
        myReviewsRepositoryImpl: MyReviewsRepositoryImpl
    ): MyReviewsRepository

    @Binds
    abstract fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun provideFeedRepository(feedRepositoryImpl: FeedRepositoryImpl): FeedRepository
}