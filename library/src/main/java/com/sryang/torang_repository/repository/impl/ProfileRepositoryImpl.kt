package com.sryang.torang_repository.repository.impl

import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.*
import com.sryang.torang_repository.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepositoryImpl @Inject constructor(
    private val loggedUserDao: LoggedInUserDao,
    private val userDao: UserDao,
    private val feedDao: FeedDao, override val isLogin: Flow<Boolean>
) : ProfileRepository {

    override fun getMyProfile(): Flow<LoggedInUserEntity?> {
        return loggedUserDao.getLoggedInUserEntity()
    }

    override fun loadProfile(userId: Int): Flow<UserEntity> {
        return userDao.getUser(userId)
    }

    override fun getMyFeed(userId: Int): Flow<List<FeedEntity>> {
        return feedDao.getMyFeed(userId)
    }

    override fun getMyFavorite(userId: Int): Flow<List<FeedEntity>> {
        return feedDao.getMyFavorite(userId)
    }

    override fun getFeed(): Flow<List<FeedEntity>> {
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

    override fun getLike(reviewId: Int): Flow<LikeEntity> {
        return userDao.getLike(reviewId)
    }

    override fun getFavorite(reviewId: Int): Flow<FavoriteEntity> {
        return userDao.getFavorite(reviewId)
    }

    override suspend fun user1(): LoggedInUserEntity? {
        return loggedUserDao.getLoggedInUserEntity1()
    }

//    override val isLogin: Flow<Boolean> = loggedUserDao.getLoggedInUserEntity().switchMap {
//        if (it != null) {
//            MutableStateFlow(it.userId != 0)
//        } else {
//            MutableStateFlow(false)
//        }
//    }


    override suspend fun isLogin(): Boolean {
        return true
    }

    override suspend fun logout() {
        loggedUserDao.clear()
    }

    override fun getReviewImages(reviewId: Int): Flow<List<ReviewImageEntity>> {
        return userDao.getReviewImages(reviewId)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileRepositoryModule {
    @Binds
    abstract fun provideProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository
}