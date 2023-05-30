package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sryang.torang_repository.data.entity.*

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM UserEntity WHERE userId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserEntity>

    /*@Query("SELECT * FROM userdata WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserData*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserAndPictureAndLikeAndRestaurantAndFeed(
        users: List<UserEntity>,
        reviewImages: List<ReviewImageEntity>,
        likes: List<LikeEntity>,
        restaurants: List<RestaurantEntity>,
        feedData: List<FeedEntity>,
        favorites: List<FavoriteEntity>,
    )

    @Transaction
    suspend fun deleteAllAndInsertAll(
        users: List<UserEntity>,
        reviewImages: List<ReviewImageEntity>,
        likes: List<LikeEntity>,
        restaurants: List<RestaurantEntity>,
        feedData: List<FeedEntity>,
        favorites: List<FavoriteEntity>,
        deleteLikes: List<LikeEntity>,
    ): Int {
        deleteLikes(deleteLikes)
        deleteAll()
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

    @Delete
    suspend fun delete(user: UserEntity)

    @Query(
        """
            SELECT FeedEntity.*, FeedEntity.profile_pic_url, UserEntity.userName, UserEntity.userId, RestaurantEntity.restaurant_name, RestaurantEntity.restaurant_id  
            FROM FeedEntity  
            JOIN UserEntity ON FeedEntity.userId =  UserEntity.userId 
            LEFT OUTER JOIN RestaurantEntity ON FeedEntity.restaurant_id = RestaurantEntity.restaurant_id 
            ORDER BY create_date DESC
            """
    )
    fun getAllFeed(): LiveData<List<FeedEntity>>


    @Query("select * from FeedEntity where review_id = (:reviewId) order by FeedEntity.create_date desc")
    fun getFeed(reviewId: Int): LiveData<ReviewAndImageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(feedData: List<FeedEntity>)

    @Query("DELETE FROM FeedEntity where review_id = (:reviewId)")
    suspend fun deleteFeed(reviewId: Int): Int

    @Query("DELETE FROM FeedEntity")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPictures(reviewImages: List<ReviewImageEntity>)

    @Query("DELETE FROM ReviewImageEntity where review_id = (:reviewId)")
    suspend fun deletePicturesByReviewId(reviewId: Int)


    @Query("select * from ReviewImageEntity where review_id = (:reviewId)")
    fun getReviewImages(reviewId: Int): LiveData<List<ReviewImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLikes(users: List<LikeEntity>)

    @Delete
    suspend fun deleteLike(like: LikeEntity)

    @Delete
    suspend fun deleteLikes(users: List<LikeEntity>)

    @Query("select * from LikeEntity where review_id = (:reviewId)")
    fun getLike(reviewId: Int): LiveData<LikeEntity>

    @Query("select * from LikeEntity where review_id = (:reviewId)")
    suspend fun getLike1(reviewId: Int): LikeEntity

    @Query("select count(*) from LikeEntity where review_id = (:reviewId)")
    suspend fun hasLike(reviewId: Int): Int

    @Query("select * from UserEntity where userId = (:userId)")
    fun getUser(userId: Int): LiveData<UserEntity>

    @Query("select * from FeedEntity order by FeedEntity.create_date desc")
    fun getAllFeedWithUser(): LiveData<List<ReviewAndImageEntity>>

    @Query("update UserEntity set userName = :userName ,profile_pic_url = :profilePicUrl  where userId = :userId")
    suspend fun update(userId: Int, userName: String, profilePicUrl: String)

    @Insert
    suspend fun insertLike(resultLike: LikeEntity)

    @Query("select count(*) from FavoriteEntity where review_id = (:reviewId)")
    suspend fun hasFavorite(reviewId: Int): Int


    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)

    @Query("select * from FavoriteEntity where review_id = (:reviewId)")
    suspend fun getFavorite1(reviewId: Int): FavoriteEntity

    @Insert
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Query("select * from FavoriteEntity where review_id = (:reviewId)")
    fun getFavorite(reviewId: Int): LiveData<FavoriteEntity>
}