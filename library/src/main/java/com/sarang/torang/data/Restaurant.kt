package com.sarang.torang.data

data class Restaurant(
    val restaurantId: Int = -1,
    val restaurantName: String = "",
    val address: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val rating: Float = 0f,
    val tel: String = "",
    val prices: String  = "",
    val restaurantType: String = "",
    val regionCode: Int = 0,
    val reviewCount: Int = 0,
    val site: String = "",
    val website: String = "",
    val imgUrl1: String = "",
    val restaurantTypeCd : String = ""
)