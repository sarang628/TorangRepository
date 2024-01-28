package com.sarang.torang.repository

import android.view.Menu
import com.sarang.torang.data.HoursOfOperation
import com.sarang.torang.data.remote.response.RemoteRestaurant

interface RestaurantRepository {
    suspend fun loadRestaurant(restaurantId: Int): RemoteRestaurant
    suspend fun loadMenus(restaurantId: Int): ArrayList<Menu>
    suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation>
}