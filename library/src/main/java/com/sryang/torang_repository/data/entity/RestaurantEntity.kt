package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestaurantEntity(
    @PrimaryKey val restaurantId: Int,
    val restaurantName: String,
    val lat: Double,
    val lon: Double,
    val rating: Float,
    val tel: String,
    val prices: String,
    val restaurantType: String,
    val regionCode: String,
    val reviewCount: String,
    val site: String,
    val website: String,
    val imgUrl1: String,
    val imgUrl2: String? = null,
    val imgUrl3: String? = null,
    val imgUrl4: String? = null,
    val imgUrl5: String? = null,
    val imgUrl6: String? = null
)
