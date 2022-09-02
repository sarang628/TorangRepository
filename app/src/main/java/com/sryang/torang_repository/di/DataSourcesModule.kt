package com.sryang.torang_repository.di

import com.sryang.torang_core.data.data.ReviewImage
import com.sryang.torang_repository.data.MyReviewsLocalDataSource
import com.sryang.torang_repository.data.MyReviewsRemoteDataSource
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {
    @Binds
    abstract fun provideLocalDataSource(myReviewsLocalDataSourceImpl: MyReviewsLocalDataSourceImpl): MyReviewsLocalDataSource

    @Binds
    abstract fun provideRemoteDataSource(myReviewsRemoteDataSourceImpl: MyReviewsRemoteDataSourceImpl): MyReviewsRemoteDataSource
}

class MyReviewsLocalDataSourceImpl @Inject constructor() : MyReviewsLocalDataSource {
    override suspend fun getMyReviews(): List<ReviewImage> {
        return ArrayList()
    }
}

class MyReviewsRemoteDataSourceImpl @Inject constructor() : MyReviewsRemoteDataSource {
    override suspend fun getMyReviews(): List<ReviewImageEntity> {
        return ArrayList()
    }
}