package com.sryang.torang_repository.repository.impl

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.torangrepository.repository.preference.TorangPreference
import com.example.torangrepository.util.CountingFileRequestBody
import com.sryang.torang_core.data.data.ModifyFeedData
import com.sryang.torang_core.repository.MyReviewRepository
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.data.dao.ReviewDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.services.RestaurantService
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.MultipartBody
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyReviewRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val reviewDao: ReviewDao,
    private val restaurantService: RestaurantService,
    private val userDao: UserDao,
    private val restaurantDao: RestaurantDao,
    private val loggedInUserDao: LoggedInUserDao
) :
    MyReviewRepository {
    override fun getMyReview(reviewId: Int): LiveData<FeedEntity?> {
        return reviewDao.getFeedbyReviewId(reviewId)
    }

    override fun getUploadedPicture(reviewId: Int): LiveData<List<ReviewImageEntity>> {
        return MutableLiveData<List<ReviewImageEntity>>()
    }


    override suspend fun uploadReview(review: ReviewAndImageEntity) {

        if (review.review == null)
            throw IllegalArgumentException("리뷰 데이터가 없습니다.")

        if (review.user == null || review.user?.userId == -1)
            throw IllegalArgumentException("사용자 정보가 없습니다.")

        val fileList = ArrayList<File>()

        review.images?.let {
            for (image in it) {
                fileList.add(File(image.picture_url))
            }
        }

        val pictureList = ArrayList<MultipartBody.Part>()

        for (i in fileList.indices) {
            val file: File = fileList.get(i)
            val requestFile = CountingFileRequestBody(file, "image/*", object :
                CountingFileRequestBody.ProgressListener {
                override fun transferred(num: Long) {

                }
            })

            pictureList.add(MultipartBody.Part.createFormData("file", file.name, requestFile))
        }

        try {
            val result = restaurantService.fileUpload(review.toMap(), pictureList)

            //피드 추가하기
            val list1 = ArrayList<ReviewAndImageEntity>()
            //list1.add(ReviewAndImageEntity.parse(result))

            //피드 추가하기
            val feeds = ArrayList<FeedEntity>()
            val images = ArrayList<ReviewImageEntity>()
            for (reviewAndInage in list1) {
                FeedEntity.parse(reviewAndInage)?.let {
                    feeds.add(it)
                }
                reviewAndInage.images?.let {
                    images.addAll(it)
                }

            }
            userDao.insertFeed(feedData = feeds)
            userDao.insertPictures(images)
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
    }

    override suspend fun modifyReview(review: ReviewAndImageEntity) {

        if (review.review == null)
            throw IllegalArgumentException("리뷰 데이터가 없습니다.")

        if (review.user == null || review.user?.userId == -1)
            throw IllegalArgumentException("사용자 정보가 없습니다.")

        val fileList = ArrayList<File>()

        review.images?.let {
            for (image in it) {
                fileList.add(File(image.picture_url))
            }
        }

        val pictureList = ArrayList<MultipartBody.Part>()

        for (i in fileList.indices) {
            val file: File = fileList.get(i)
            val requestFile = CountingFileRequestBody(file, "image/*", object :
                CountingFileRequestBody.ProgressListener {
                override fun transferred(num: Long) {

                }
            })

            pictureList.add(MultipartBody.Part.createFormData("file", file.name, requestFile))
        }

        try {
            val result = restaurantService.updateReview(review.toMap(), pictureList)

            //피드 추가기
            val list1 = ArrayList<ReviewAndImageEntity>()
            //list1.add(ReviewAndImageEntity.parse(result))

            //피드 추가하기
            val feeds = ArrayList<FeedEntity>()
            val images = ArrayList<ReviewImageEntity>()
            for (reviewAndInage in list1) {
                FeedEntity.parse(reviewAndInage)?.let {
                    feeds.add(it)
                }
                reviewAndInage.images?.let {
                    images.addAll(it)
                }

            }
            userDao.insertFeed(feedData = feeds)
            userDao.insertPictures(images)
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
    }

    override suspend fun modifyReview(review: ModifyFeedData) {

        /*if (review.reviewAndImage.review == null)
            throw IllegalArgumentException("리뷰 데이터가 없습니다.")*/

        /*if (review.reviewAndImage.user == null || review.reviewAndImage.user?.userId == -1)
            throw IllegalArgumentException("사용자 정보가 없습니다.")*/

        val fileList = ArrayList<File>()

        /*review.reviewAndImage.images?.let {
            for (image in it) {
                fileList.add(File(image.picture_url))
            }
        }*/

        val pictureList = ArrayList<MultipartBody.Part>()

        for (i in fileList.indices) {
            val file: File = fileList.get(i)
            val requestFile = CountingFileRequestBody(file, "image/*", object :
                CountingFileRequestBody.ProgressListener {
                override fun transferred(num: Long) {

                }
            })

            pictureList.add(MultipartBody.Part.createFormData("file", file.name, requestFile))
        }

        try {
            val result = restaurantService.updateReview(review.toMap(), pictureList)

            //피드 추가기
            val list1 = ArrayList<ReviewAndImageEntity>()
            //list1.add(ReviewAndImageEntity.parse(result))

            //피드 추가하기
            val feeds = ArrayList<FeedEntity>()
            val images = ArrayList<ReviewImageEntity>()
            for (reviewAndInage in list1) {
                FeedEntity.parse(reviewAndInage)?.let {
                    feeds.add(it)
                }
                reviewAndInage.images?.let {
                    //images.addAll(it)
                }

            }
            userDao.insertFeed(feedData = feeds)
            //userDao.deletePicturesByReviewId(review.reviewAndImage.review!!.review_id)
            userDao.insertPictures(images)
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
    }

    override suspend fun getRestaurant(restaurantId: Int): RestaurantEntity? {
        return restaurantDao.getRestaurantByRestaurantId(restaurantId)
    }

    override fun userId(): Int {
        return TorangPreference().getUserId(context)
    }

    override suspend fun userId1(): Int {
        var userId = -1

        loggedInUserDao.getLoggedInUserEntity1()?.let {
            var data = it
            userId = it.userId!!
            Logger.d(data)
        }

        loggedInUserDao.getLoggedInUserEntity1()?.userId?.let {
            userId = it
        }
        return userId
    }
}
