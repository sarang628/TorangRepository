package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.data.Filter
import com.sryang.torang_repository.data.entity.RestaurantEntity

interface MapSharedRepository {
    suspend fun searchRestaurant(latitude: Double, longitude: Double): List<RestaurantEntity>
    suspend fun searchRestaurant(keyword: String): List<RestaurantEntity>
    suspend fun getFilterRestaurant(filter: Filter): List<RestaurantEntity>
}