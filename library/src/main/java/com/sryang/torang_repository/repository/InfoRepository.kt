package com.sryang.torang_repository.repository

import android.view.Menu
import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.HoursOfOperation
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant

interface InfoRepository {
    suspend fun loadRestaurant(restaurantId: Int): RemoteRestaurant
    suspend fun loadMenus(restaurantId: Int): ArrayList<Menu>
    suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation>
}