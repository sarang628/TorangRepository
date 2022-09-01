package com.sryang.torang_repository.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.sryang.torang_core.repository.ProfileRepository
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepositoryImpl @Inject constructor(
    private val loggedUserDao: LoggedInUserDao,
    private val userDao: UserDao,
    private val feedDao: FeedDao
) : ProfileRepository {

    override fun getMyProfile(): LiveData<LoggedInUserEntity?> {
        return loggedUserDao.getLoggedInUserEntity()
    }

    override fun loadProfile(userId: Int): LiveData<UserEntity> {
        return userDao.getUser(userId)
    }

    override fun getMyFeed(userId: Int): LiveData<List<FeedEntity>> {
        return feedDao.getMyFeed(userId)
    }

    override fun getMyFavorite(userId: Int): LiveData<List<FeedEntity>> {
        return feedDao.getMyFavorite(userId)
    }

    override fun getFeed(): LiveData<List<FeedEntity>> {
        return userDao.getAllFeed()
    }

    override suspend fun loadFeed() {

    }

    override suspend fun like(reviewId: Int) {
        //userDao.insertLike(reviewId)
    }

    override suspend fun favorite(reviewId: Int) {
        TODO("Not yet implemented")
    }

    override fun getLike(reviewId: Int): LiveData<LikeEntity> {
        return userDao.getLike(reviewId)
    }

    override fun getFavorite(reviewId: Int): LiveData<FavoriteEntity> {
        return userDao.getFavorite(reviewId)
    }

    override suspend fun user1(): LoggedInUserEntity? {
        return loggedUserDao.getLoggedInUserEntity1()
    }

    override val isLogin: LiveData<Boolean> = loggedUserDao.getLoggedInUserEntity().switchMap {
        if (it != null) {
            MutableLiveData(it.userId != 0)
        } else {
            MutableLiveData(false)
        }
    }


    override suspend fun isLogin(): Boolean {
        return true
    }

    override suspend fun logout() {
        loggedUserDao.clear()
    }

    override fun getReviewImages(reviewId: Int): LiveData<List<ReviewImageEntity>> {
        return userDao.getReviewImages(reviewId)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileRepositoryModule {
    @Binds
    abstract fun provideProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository
}