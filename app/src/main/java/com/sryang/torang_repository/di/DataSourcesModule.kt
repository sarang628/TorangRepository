package com.sryang.torang_repository.di

import com.sryang.torang_core.data.data.ReviewImage
import com.sryang.torang_repository.data.datasource.FeedRemoteDataSource
import com.sryang.torang_repository.data.datasource.MyReviewsLocalDataSource
import com.sryang.torang_repository.data.datasource.MyReviewsRemoteDataSource
import com.sryang.torang_repository.data.datasource.impl.FeedRemoteDataSourceImpl
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
    abstract fun provideLocalDataSource(
        dataSource: MyReviewsLocalDataSourceImpl
    ): MyReviewsLocalDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        dataSource: MyReviewsRemoteDataSourceImpl
    ): MyReviewsRemoteDataSource

    @Binds
    abstract fun provideFeedRemoteDataSource(
        dataSource: FeedRemoteDataSourceImpl
    ): FeedRemoteDataSource
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