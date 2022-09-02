package com.sryang.torang_repository.repository.impl

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.sryang.torang_repository.repository.preference.TorangPreference
import com.sryang.torang_core.data.data.Comment
import com.sryang.torang_core.data.data.Restaurant
import com.sryang.torang_core.data.data.User
import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.dao.CommentDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.data.dao.ReviewDao
import com.sryang.torang_repository.data.entity.CommentEntity
import com.sryang.torang_repository.repository.TimeLineDetailRepository
import com.sryang.torang_repository.services.RestaurantService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeLineDetailRepositoryImpl @Inject constructor(
    private val restaurantService: RestaurantService,
    private val commentDao: CommentDao,
    private val restaurantDao: RestaurantDao,
    private val reviewDao: ReviewDao,
    private val loggedInUserDao: LoggedInUserDao
) :
    TimeLineDetailRepository {

    override suspend fun getComments(reviewId: String): ArrayList<Comment> {
        val list = restaurantService.getComments(reviewId)
        commentDao.insertComments(CommentEntity.parse(list))
        return list
    }

    override fun getComments(reviewId: Int): LiveData<List<CommentEntity>> {
        Logger.d("getComments $reviewId")
        return commentDao.getComments(reviewId)
    }

    override fun getReview(): LiveData<Feed> {
        TODO("Not yet implemented")
    }

    override fun getRestaurant(reviewId: Int): LiveData<Restaurant> {
        //return restaurantDao.getRestaurantByReviewId(reviewId)
        TODO()
    }

    override fun getFeed(reviewId: Int): LiveData<Feed> {
        //return reviewDao.getFeedbyReviewId(reviewId)
        TODO()
    }

    override suspend fun addComment(reviewId: Int, value: String): Comment {

        /*val comment = restaurantService.addComment(Comment().apply {
            user = User().apply { userId = loggedInUserDao.getLoggedInUserEntity1()!!.userId!! }
            comment = value
            review_id = reviewId
        })

        commentDao.insertComment(Comment.parse(comment))

        return comment*/
        TODO()
    }

    /** 로그인 여부 */
    override val isLogin: LiveData<Boolean> = loggedInUserDao.getLoggedInUserEntity().switchMap {
        if (it != null) {
            MutableLiveData(it.userId != 0)
        } else {
            MutableLiveData(false)
        }
    }
}

@Singleton
class TimeLineDetailRepositoryTestImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val restaurantDao: RestaurantDao,
    private val restaurantService: RestaurantService,
    private val reviewDao: ReviewDao,
    private val loggedInUserDao: LoggedInUserDao
) :
    TimeLineDetailRepository {

    override suspend fun getComments(reviewId: String): ArrayList<Comment> {
        return restaurantService.getComments(reviewId)
    }

    override fun getComments(reviewId: Int): LiveData<List<CommentEntity>> {
        TODO("Not yet implemented")
    }

    override fun getReview(): LiveData<Feed> {
        TODO("Not yet implemented")
    }

    override fun getRestaurant(reviewId: Int): LiveData<Restaurant> {
        //return restaurantDao.getRestaurantByReviewId(reviewId)
        TODO()
    }

    override fun getFeed(reviewId: Int): LiveData<Feed> {
        //return reviewDao.getFeedbyReviewId(reviewId)
        TODO()
    }

    fun userId(): Int {
        return if (context != null)
            TorangPreference().getUserId(context!!)
        else -1
    }

    override suspend fun addComment(reviewId: Int, value: String): Comment {
        return restaurantService.addComment(Comment().apply {
            user = User().apply { userId = userId() }
            comment = value
            review_id = reviewId
        })
    }

    /** 로그인 여부 */
    override val isLogin: LiveData<Boolean> = loggedInUserDao.getLoggedInUserEntity().switchMap {
        if (it != null) {
            MutableLiveData(it.userId != 0)
        } else {
            MutableLiveData(false)
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class TimeLineDetailRepositoryModule {
    @Binds
    abstract fun bindTimeLineDetailRepository(
        timeLineDetailRepositoryImpl: TimeLineDetailRepositoryImpl
    ): TimeLineDetailRepository
}
