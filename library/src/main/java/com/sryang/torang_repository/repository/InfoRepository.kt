package com.sryang.torang_repository.repository

import android.view.Menu
import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.HoursOfOperation

interface InfoRepository {
    suspend fun loadRestaurant(restaurantId: Int): Restaurant
    suspend fun loadMenus(restaurantId: Int): ArrayList<Menu>
    suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation>
}