package com.sryang.torang_repository.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRestaurant(restaurants: ArrayList<RestaurantEntity>)

    @Query("select * from RestaurantEntity order by restaurantName desc")
    fun getRestaurant(): Flow<List<RestaurantEntity>>

    @Query("select * from RestaurantEntity order by restaurantName desc")
    suspend fun getRestaurantDistance(): List<RestaurantEntity>


    @Query("select * from RestaurantEntity Where restaurantId = (SELECT restaurantId FROM FeedEntity WHERE reviewId = :reviewId)")
    fun getRestaurantByReviewId(reviewId: Int): Flow<RestaurantEntity>

    @Query("select * from RestaurantEntity Where restaurantId = :restaurantId")
    suspend fun getRestaurantByRestaurantId(restaurantId: Int): RestaurantEntity?
}