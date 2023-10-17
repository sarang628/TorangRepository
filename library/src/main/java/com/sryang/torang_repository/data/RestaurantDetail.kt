package com.sryang.torang_repository.data

import com.google.gson.Gson
import com.sryang.torang_repository.Menu
import com.sryang.torang_repository.Picture
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant

data class RestaurantDetail(
    val restaurant: RemoteRestaurant,
    val pictures: ArrayList<Picture>,
    val comments: ArrayList<RestaurantComment>,
    val menus: ArrayList<Menu>,
    val hoursOfOperations: List<HoursOfOperation>,
    val restaurantRating: RestaurantRating
) {
    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }
}