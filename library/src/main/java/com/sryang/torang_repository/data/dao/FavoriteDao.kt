package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FavoriteEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("select count(*) from FavoriteEntity where review_id = (:reviewId)")
    suspend fun hasFavorite(reviewId: Int): Int


    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)

    @Query("select * from FavoriteEntity where review_id = (:reviewId)")
    suspend fun getFavorite1(reviewId: Int): FavoriteEntity

    @Insert
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Query("select * from FavoriteEntity where review_id = (:reviewId)")
    fun getFavorite(reviewId: Int): Flow<FavoriteEntity>

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

    @Query(
        """
        DELETE FROM FavoriteEntity
    """
    )
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(feedList: List<FavoriteEntity>)
}