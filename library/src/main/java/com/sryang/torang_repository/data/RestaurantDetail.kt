package com.sryang.torang_repository.data

import com.google.gson.Gson
import com.sryang.torang_repository.Menu
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant

data class RestaurantDetail(
    val restaurant: RemoteRestaurant,
    val pictures: ArrayList<ReviewImageEntity>,
    val comments: ArrayList<RestaurantComment>,
    val menus: ArrayList<Menu>,
    val restaurantRating: RestaurantRating
) {
    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }
}