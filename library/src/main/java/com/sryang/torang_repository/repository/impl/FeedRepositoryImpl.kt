package com.sryang.torang_repository.repository.impl

import android.content.Context
import com.example.torangrepository.repository.preference.TorangPreference
import com.sryang.torang_repository.services.FeedServices
import com.sryang.torang_core.data.data.Review
import com.sryang.torang_core.data.remote.RemoteFeed
import com.sryang.torang_core.repository.FeedRepository
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val feedServices: FeedServices, // 원격 저장소 주입
    private val userDao: UserDao, // 로컬 저장소 주입
    private val user: LoggedInUserDao // 로컬 저장소 주입
) : FeedRepository {

    fun userId(): Int {
        return TorangPreference().getUserId(context)
    }

    override suspend fun deleteFeed(reviewId: Int) {
        try {
            //원격 저장소 요청
            feedServices.deleteReview(Review().apply { this.review_id = reviewId })
        } catch (e: java.lang.Exception) {
            Logger.e(e.toString())
        }
        //로컬 저장소에서 삭제
        userDao.deleteFeed(reviewId)
    }

    override suspend fun loadFeed(): ArrayList<RemoteFeed> {
        //val feeds = feedServices.getFeeds(HashMap())
        return ArrayList()
    }
}