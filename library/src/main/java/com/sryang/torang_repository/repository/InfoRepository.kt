package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.entity.HoursOfOperation
import com.sryang.torang_core.data.entity.Menu
import com.sryang.torang_core.data.entity.Restaurant

interface InfoRepository {
    suspend fun loadRestaurant(restaurantId: Int): Restaurant
    suspend fun loadMenus(restaurantId: Int): ArrayList<Menu>
    suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation>
}