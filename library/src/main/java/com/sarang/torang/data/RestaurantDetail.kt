package com.sarang.torang.data

import com.google.gson.Gson
import com.sarang.torang.Menu
import com.sarang.torang.Picture
import com.sarang.torang.data.remote.response.RestaurantApiModel

data class RestaurantDetail(
    val restaurant: RestaurantApiModel,
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