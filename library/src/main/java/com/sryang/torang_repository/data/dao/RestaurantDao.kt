package com.sryang.torang_repository.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sryang.torang_repository.data.entity.RestaurantEntity

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRestaurant(restaurants: ArrayList<RestaurantEntity>)

    @Query("select * from RestaurantEntity order by restaurant_name desc")
    fun getRestaurant(): LiveData<List<RestaurantEntity>>

    @Query("select * from RestaurantEntity order by restaurant_name desc")
    suspend fun getRestaurantDistance(): List<RestaurantEntity>


    @Query("select * from RestaurantEntity Where restaurant_id = (SELECT restaurant_id FROM FeedEntity WHERE review_id = :reviewId)")
    fun getRestaurantByReviewId(reviewId: Int): LiveData<RestaurantEntity>

    @Query("select * from RestaurantEntity Where restaurant_id = :restaurantId")
    suspend fun getRestaurantByRestaurantId(restaurantId: Int): RestaurantEntity?
}