package com.sarang.torang.data

import com.google.gson.Gson
import com.sarang.torang.data.remote.response.RestaurantResponseDto

data class RestaurantDetail(
    val restaurant: RestaurantResponseDto,
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