package com.sryang.torang_repository.repository.profile

import android.util.Log
import com.sryang.torang_repository.api.ApiProfile
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.FavoriteEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LikeEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.data.entity.UserEntity
import com.sryang.torang_repository.data.remote.response.RemoteUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

fun RemoteUser.toUserEntity(): UserEntity {
    return UserEntity(
        userId = this.userId,
        userName = this.userName,
        email = this.email,
        profile_pic_url = this.profilePicUrl,
        review_count = this.reviewCount.toString()
    )
}

@Singleton
class ProfileRepositoryImpl @Inject constructor(
    private val apiProfile: ApiProfile,
    private val loggedUserDao: LoggedInUserDao,
    private val userDao: UserDao,
    private val feedDao: FeedDao
) : ProfileRepository {

    override fun getMyProfile(): Flow<LoggedInUserEntity?> {
        return loggedUserDao.getLoggedInUserEntity()
    }

    override suspend fun loadProfile(userId: Int): UserEntity {

        val remoteUser = apiProfile.getProfile(userId.toString())

        if (remoteUser.body() == null)
            throw Exception("")

        return remoteUser.body()!!.toUserEntity()
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