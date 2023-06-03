package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.FeedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedDao {
    @Query("""
        SELECT FeedEntity.*, 
               UserEntity.profile_pic_url,
               UserEntity.userName, 
               UserEntity.userId, 
               RestaurantEntity.restaurant_name, 
               RestaurantEntity.restaurant_id
        FROM FeedEntity 
        JOIN UserEntity ON FeedEntity.userId =  UserEntity.userId
        LEFT OUTER JOIN RestaurantEntity ON FeedEntity.restaurant_id = RestaurantEntity.restaurant_id
        WHERE FeedEntity.userId = (:userId)
        ORDER BY create_date DESC
        """
    )
    fun getMyFeed(userId: Int): Flow<List<FeedEntity>>

    @Query("""
        SELECT FeedEntity.*, UserEntity.profile_pic_url, UserEntity.userName, UserEntity.userId, RestaurantEntity.restaurant_name, RestaurantEntity.restaurant_id
        FROM FeedEntity 
        JOIN UserEntity ON FeedEntity.userId =  UserEntity.userId
        LEFT OUTER JOIN RestaurantEntity ON FeedEntity.restaurant_id = RestaurantEntity.restaurant_id
        WHERE review_id IN (Select review_id from FavoriteEntity where user_id = (:userId) )
        ORDER BY create_date DESC
        """)
    fun getMyFavorite(userId: Int): Flow<List<FeedEntity>>

    @Query("DELETE FROM FeedEntity where review_id = (:reviewId)")
    suspend fun deleteFeed(reviewId: Int) : Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plantList: List<FeedEntity>)
}