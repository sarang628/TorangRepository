package com.sryang.torang_repository.repository.impl

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.remote.response.*
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import com.sryang.torang_repository.repository.FeedRepository
import com.sryang.torang_repository.repository.preference.TorangPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.streams.toList

@Singleton
class FeedRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val remoteDataSource: FeedRemoteDataSource, // 원격 저장소 주입
    private val userDao: UserDao, // 로컬 저장소 주입
    private val user: LoggedInUserDao // 로컬 저장소 주입
) : FeedRepository {

    fun userId(): Int {
        return TorangPreference().getUserId(context)
    }

    override suspend fun deleteFeed(reviewId: Int) {
        try {
            //원격 저장소 요청
            //feedServices.deleteReview(Review().apply { this.review_id = reviewId })
        } catch (e: java.lang.Exception) {
            Logger.e(e.toString())
        }
        //로컬 저장소에서 삭제
        userDao.deleteFeed(reviewId)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun loadFeed(): Response<List<Feed>> {

        try {
            val feedList = remoteDataSource.getFeeds(HashMap())
            return Response(
                status = 200,
                data = feedList.stream().map {
                    Feed(
                        user = it.toUser(),
                        review = it.toReview(),
                        like = it.toLike(),
                        favorite = it.toFavorite(),
                        comment = it.toComment(),
                        likeAmount = it.like_amount,
                        commentAmount = it.comment_amount,
                    )
                }.toList()
            )
        } catch (e: UnknownHostException) {
            Logger.e(e.toString())
            return Response(status = 400)
        } catch (e: IOException) {
            Logger.e(e.toString())
            return Response(status = 400)
        }
        return Response(status = 400)
    }

}