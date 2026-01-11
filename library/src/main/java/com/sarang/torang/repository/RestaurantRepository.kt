package com.sarang.torang.repository

import com.sarang.torang.data.HoursOfOperation
import com.sarang.torang.data.Menu
import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.RestaurantDetail

interface RestaurantRepository {
    suspend fun loadRestaurant(restaurantId: Int): Restaurant
    suspend fun loadMenus(restaurantId: Int): List<Menu>
    suspend fun loadHours(restaurantId: Int): List<HoursOfOperation>
    suspend fun loadRestaurantDetail(restaurantId: Int): RestaurantDetail
}