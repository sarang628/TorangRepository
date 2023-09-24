package com.sryang.torang_repository.repository.feed

import com.sryang.library.entity.Feed
import com.sryang.library.entity.Restaurant
import com.sryang.library.entity.user.User
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.PictureDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import com.sryang.torang_repository.data.entity.UserEntity
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.data.remote.response.toReviewImage
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.streams.toList

@Singleton
class FeedRepositoryImpl @Inject constructor(
    private val remoteDataSource: FeedRemoteDataSource,
    private val feedDao: FeedDao,
    private val pictureDao: PictureDao,
    private val userDao: UserDao
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

    override suspend fun loadFeed() {
        val feedList = remoteDataSource.getFeeds(HashMap())
        feedDao.insertAll(feedList.stream().map {
            it.toFeedEntity()
        }.toList())

        for (feed in feedList) {
            pictureDao.insertPictures(feed.pictures.stream().map { it.toReviewImage() }.toList())
        }

        userDao.insertAll(feedList.stream().map {
            it.toUserEntity()
        }.toList())
    }

}

fun RemoteFeed.toUserEntity(): UserEntity {
    return UserEntity(
        userId = this.user?.userId ?: 0,
        email = this.user?.email ?: "",
        loginPlatform = this.user?.loginPlatform ?: "",
        create_date = this.user?.createDate ?: "",
        access_token = "",
        profile_pic_url = this.user?.profilePicUrl,
        point = 0,
        review_count = "0",
        following = "0",
        followers = "0"

    )
}

fun RemoteFeed.toFeedEntity(): FeedEntity {
    return FeedEntity(
        reviewId = this.reviewId,
        userId = this.user?.userId ?: 0,
        rating = this.rating ?: 0f,
        userName = this.user?.userName ?: "",
        profilePicUrl = this.user?.profilePicUrl ?: "",
        likeAmount = this.like_amount ?: 0,
        commentAmount = this.comment_amount ?: 0,
        restaurantName = this.restaurant?.restaurantName ?: "",
        restaurantId = this.restaurant?.restaurantId ?: 0,
        contents = this.contents ?: "",
        createDate = this.create_date ?: ""
    )
}

fun RemoteFeed.toFeed(): Feed {
    return Feed(
        reviewId = this.reviewId,
        writer = User(
            userId = 0,
            name = this.user?.userName ?: "",
            profilePictureUrl = this.user?.profilePicUrl ?: ""
        ),
        restaurant = Restaurant(
            restaurantName = this.restaurant?.restaurantName ?: ""
        ),
        rating = this.rating ?: 0.0f,
        likeAmount = this.like_amount ?: 0,
        commentAmount = this.comment_amount ?: 0,
        comments = ArrayList(),
        isLike = this.like?.isLike ?: false,
        isFavorite = this.favorite?.isFavority ?: false,
        reviewImages = this.pictures.stream().map { it.picture_url }.toList(),
        contents = this.contents ?: ""
    )
}