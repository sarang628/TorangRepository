package com.sryang.torang_repository.data

import android.graphics.Picture
import com.google.gson.Gson
import com.sryang.torang_repository.Menu
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant

data class RestaurantDetail(
    val restaurant: RemoteRestaurant,
    val pictures: ArrayList<Picture>,
    val comments: ArrayList<RestaurantComment>,
    val menus: ArrayList<Menu>,
    val restaurantRating: RestaurantRating
) {
    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }
}