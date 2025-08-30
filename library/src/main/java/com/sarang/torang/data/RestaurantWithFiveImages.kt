package com.sarang.torang.data

data class RestaurantWithFiveImages(
    val restaurant: Restaurant = Restaurant(),
    val images: List<String> = listOf()
) {
    companion object
}