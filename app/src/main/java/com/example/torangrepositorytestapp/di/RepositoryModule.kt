package com.example.torangrepositorytestapp.di

import com.example.torang_core.repository.FeedRepository
import com.example.torang_core.repository.LoginRepository
import com.example.torang_core.repository.MyReviewsRepository
import com.example.torangrepository.repository.impl.FeedRepositoryImpl
import com.example.torangrepository.repository.impl.LoginRepositoryImpl
import com.example.torangrepository.repository.impl.MyReviewsRepositoryImpl
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