package com.sarang.torang.repository

import com.sarang.torang.data.Filter
import com.sarang.torang.data.RestaurantWithFiveImages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FindRepository {
    val restaurants: Flow<List<RestaurantWithFiveImages>>
    suspend fun search(filter: Filter = Filter())
    suspend fun findFilter()
    suspend fun findThisArea()
    suspend fun setFoodType(foodType : String)
    suspend fun setPrice(price : String)
    suspend fun setRating(rating : String)
    suspend fun setKeyword(keyword : String)
    fun getFoodType(): StateFlow<List<String>>
    fun getPrices(): StateFlow<List<String>>
    fun getRatings(): StateFlow<List<String>>
    suspend fun selectRestaurantFromMarker(restaurantId: Int)
    suspend fun selectRestaurantFromSwipe(restaurantId: Int)
    suspend fun selectRestaurant(restaurantId: Int)
}