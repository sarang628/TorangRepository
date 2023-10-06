package com.sryang.torang_repository.di.repository.repository

import android.util.Log
import com.google.gson.Gson
import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.data.RemoteLike
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LikeDao
import com.sryang.torang_repository.data.dao.PictureDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LikeEntity
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import com.sryang.torang_repository.data.entity.UserEntity
import com.sryang.torang_repository.data.remote.response.LikeResponse
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.data.remote.response.toReviewImage
import com.sryang.torang_repository.repository.feed.FeedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.streams.toList

@Singleton
class FeedRepositoryImpl @Inject constructor(
    private val apiFeed: ApiFeed,
    private val feedDao: FeedDao,
    private val pictureDao: PictureDao,
    private val userDao: UserDao,
    private val likeDao: LikeDao
) : FeedRepository {
    override val feeds1: Flow<List<ReviewAndImageEntity>> = feedDao.getAllFeedWithUser()

    override suspend fun deleteFeed(reviewId: Int) {
        //원격 저장소 요청
        //remoteDataSource.deleteFeed(reviewId)
        //로컬 저장소에서 삭제
        feedDao.deleteFeed(reviewId)
    }

    override suspend fun deleteFeedAll() {
        feedDao.deleteAll()
    }

    override suspend fun loadFeed(userId: Int) {
        val feedList = apiFeed.getFeeds(userId = userId)
        try {
            feedDao.insertAll(feedList.stream().map {
                it.toFeedEntity()
            }.toList())

            val list = feedList
                .stream().map { it.pictures }.toList()
                .stream().flatMap { it.stream() }.toList()
                .stream().map { it.toReviewImage() }.toList()

            feedDao.insertAllFeed(
                feedList = feedList.stream().map { it.toFeedEntity() }.toList(),
                userDao = userDao,
                pictureDao = pictureDao,
                reviewImages = list,
                userList = feedList.stream().map { it.toUserEntity() }.toList(),
                likeDao = likeDao,
                likeList = feedList.stream().filter { it.like != null }
                    .map { it.like!!.toLikeEntity() }.toList()
            )
        } catch (e: Exception) {
            Log.e("FeedRepositoryImpl", e.toString())
            Log.e(
                "FeedRepositoryImpl",
                Gson().newBuilder().setPrettyPrinting().create().toJson(feedList)
            )
        }
    }

    override suspend fun addLike(userId: Int, reviewId: Int) {
        val result = apiFeed.addLike(userId, reviewId)
        likeDao.insertLike(result.toLikeEntity())
    }

    override suspend fun deleteLike(userId: Int, reviewId: Int) {
        val like = likeDao.getLike1(reviewId = reviewId)
        val remoteLike = apiFeed.deleteLike(like.like_id)
        likeDao.deleteLike(
            remoteLike.toLikeEntity()
        )
    }

}

fun RemoteFeed.toUserEntity(): UserEntity {
    return UserEntity(
        userId = this.user.userId ?: 0,
        email = this.user.email ?: "",
        loginPlatform = this.user.loginPlatform ?: "",
        create_date = this.user.createDate ?: "",
        access_token = "",
        profile_pic_url = this.user.profilePicUrl,
        point = 0,
        review_count = "0",
        following = "0",
        followers = "0"

    )
}

fun RemoteFeed.toFeedEntity(): FeedEntity {
    return FeedEntity(
        reviewId = this.reviewId,
        userId = this.user.userId,
        rating = this.rating,
        userName = this.user.userName,
        profilePicUrl = this.user.profilePicUrl,
        likeAmount = this.like_amount,
        commentAmount = this.comment_amount,
        restaurantName = this.restaurant.restaurantName,
        restaurantId = this.restaurant.restaurantId,
        contents = this.contents,
        createDate = this.create_date
    )
}

fun LikeResponse.toLikeEntity(): LikeEntity {
    return LikeEntity(
        reviewId = this.review_id,
        like_id = this.like_id,
        user_id = this.user_id,
        create_date = this.create_date
    )
}

fun RemoteLike.toLikeEntity(): LikeEntity {
    return LikeEntity(
        like_id = likeId,
        user_id = userId,
        create_date = createDate,
        reviewId = reviewId
    )
}