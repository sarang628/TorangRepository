package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.data.HoursOfOperation
import com.sryang.torang_core.data.data.Menu
import com.sryang.torang_core.data.data.Restaurant

interface InfoRepository {
    suspend fun loadRestaurant(restaurantId: Int): Restaurant
    suspend fun loadMenus(restaurantId: Int): ArrayList<Menu>
    suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation>
}