package com.sryang.torang_repository.repository.feed

import com.sryang.library.entity.Feed
import com.sryang.library.entity.Restaurant
import com.sryang.library.entity.user.User
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.datasource.FeedRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.streams.toList

@Singleton
class FeedRepositoryImpl @Inject constructor(
    private val remoteDataSource: FeedRemoteDataSource,
    private val userDao: UserDao,
    private val user: LoggedInUserDao
) : FeedRepository {

    override suspend fun deleteFeed(reviewId: Int) {
        //원격 저장소 요청
        //remoteDataSource.deleteFeed(reviewId)
        //로컬 저장소에서 삭제
        userDao.deleteFeed(reviewId)
    }

    override suspend fun loadFeed(): List<RemoteFeed> {
        val feedList = remoteDataSource.getFeeds(HashMap())
        return feedList
    }

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