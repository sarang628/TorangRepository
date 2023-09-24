package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sryang.torang_repository.data.ReviewImage
import com.sryang.torang_repository.data.entity.FavoriteEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.FeedEntity1
import com.sryang.torang_repository.data.entity.LikeEntity
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedDao {

    @Query(
        """
        SELECT FeedEntity.reviewId,/*1*/
               FeedEntity.userId,/*2*/
               FeedEntity.restaurantId,/*3*/
               FeedEntity.userName,/*4*/
               FeedEntity.restaurantName,/*5*/
               FeedEntity.profilePicUrl,/*6*/
               FeedEntity.contents,/*7*/
               FeedEntity.rating,/*8*/
               FeedEntity.likeAmount,/*9*/
               FeedEntity.commentAmount,/*10*/
               FeedEntity.createDate,/*11*/
               UserEntity.profile_pic_url,
               UserEntity.userName, 
               UserEntity.userId,
               RestaurantEntity.restaurant_name, 
               RestaurantEntity.restaurant_id
        FROM FeedEntity 
        JOIN UserEntity ON FeedEntity.userId =  UserEntity.userId
        LEFT OUTER JOIN RestaurantEntity ON FeedEntity.restaurantId = RestaurantEntity.restaurant_id
        ORDER BY create_date DESC
        """
    )
    fun getAllFeed(): Flow<List<FeedEntity>>

    @Query(
        """
        SELECT FeedEntity.*, 
               UserEntity.profile_pic_url,
               UserEntity.userName, 
               UserEntity.userId, 
               RestaurantEntity.restaurant_name, 
               RestaurantEntity.restaurant_id
        FROM FeedEntity 
        JOIN UserEntity ON FeedEntity.userId =  UserEntity.userId
        LEFT OUTER JOIN RestaurantEntity ON FeedEntity.restaurantId = RestaurantEntity.restaurant_id
        WHERE FeedEntity.userId = (:userId)
        ORDER BY create_date DESC
        """
    )
    fun getMyFeed(userId: Int): Flow<List<FeedEntity>>

    @Query(
        """
        SELECT FeedEntity.*, UserEntity.profile_pic_url, UserEntity.userName, UserEntity.userId, RestaurantEntity.restaurant_name, RestaurantEntity.restaurant_id
        FROM FeedEntity 
        JOIN UserEntity ON FeedEntity.userId =  UserEntity.userId
        LEFT OUTER JOIN RestaurantEntity ON FeedEntity.restaurantId = RestaurantEntity.restaurant_id
        WHERE reviewId IN (Select reviewId from FavoriteEntity where user_id = (:userId) )
        ORDER BY create_date DESC
        """
    )
    fun getMyFavorite(userId: Int): Flow<List<FeedEntity>>

    @Query("select * from FeedEntity order by FeedEntity.createDate desc")
    fun getAllFeedWithUser(): Flow<List<ReviewAndImageEntity>>

    @Query("DELETE FROM FeedEntity where reviewId = (:reviewId)")
    suspend fun deleteFeed(reviewId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plantList: List<FeedEntity>)

    @Query("DELETE FROM FeedEntity")
    suspend fun deleteAllFeed()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(feedData: List<FeedEntity>)

    @Query("DELETE FROM FeedEntity")
    suspend fun deleteAll()

    @Query("select * from FeedEntity where reviewId = (:reviewId) order by FeedEntity.createDate desc")
    fun getFeed(reviewId: Int): Flow<ReviewAndImageEntity>

    @Transaction
    suspend fun deleteAllAndInsertAll(
        likeDao: LikeDao,
        feedDao: FeedDao,
        users: List<UserEntity>,
        reviewImages: List<ReviewImageEntity>,
        likes: List<LikeEntity>,
        restaurants: List<RestaurantEntity>,
        feedData: List<FeedEntity>,
        favorites: List<FavoriteEntity>,
        deleteLikes: List<LikeEntity>,
    ): Int {
        likeDao.deleteLikes(deleteLikes)
        feedDao.deleteAll()
        insertUserAndPictureAndLikeAndRestaurantAndFeed(
            users,
            reviewImages,
            likes,
            restaurants,
            feedData,
            favorites
        )
        return 0
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserAndPictureAndLikeAndRestaurantAndFeed(
        users: List<UserEntity>,
        reviewImages: List<ReviewImageEntity>,
        likes: List<LikeEntity>,
        restaurants: List<RestaurantEntity>,
        feedData: List<FeedEntity>,
        favorites: List<FavoriteEntity>,
    )

    @Query("DELETE FROM ReviewImageEntity where reviewId = (:reviewId)")
    suspend fun deletePicturesByReviewId(reviewId: Int)

    @Query("select * from ReviewImageEntity where reviewId = (:reviewId)")
    fun getReviewImages(reviewId: Int): Flow<List<ReviewImageEntity>>
}