package com.sarang.torang.data

import com.google.gson.Gson
import com.sarang.torang.data.entity.RestaurantEntity
import com.sarang.torang.data.entity.SearchedRestaurantEntity
import com.sarang.torang.data.remote.response.RestaurantResponseDto

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

fun RestaurantEntity.toEntity() : Restaurant{
    return Restaurant(restaurantId = restaurantId, restaurantName = restaurantName, address = address, lat = lat, lon = lon, rating = rating, tel = tel, prices = prices, restaurantType = restaurantType, regionCode = regionCode, reviewCount = reviewCount, site = site, website = website, imgUrl1 = imgUrl1)
}

fun SearchedRestaurantEntity.Companion.fromRestaurantEntity(restaurantEntity: RestaurantEntity): SearchedRestaurantEntity {
    val gson = Gson()
    val json = gson.toJson(restaurantEntity)
    return gson.fromJson(json, SearchedRestaurantEntity::class.java)
}

fun SearchedRestaurantEntity.Companion.fromRestaurantEntity(models: List<RestaurantEntity>): List<SearchedRestaurantEntity> {
    return models.map { it ->
        SearchedRestaurantEntity.fromRestaurantEntity(it)
    }
}

fun SearchedRestaurantEntity.Companion.fromRestaurantApiModel(restaurantEntity: RestaurantResponseDto): SearchedRestaurantEntity {
    val gson = Gson()
    val json = gson.toJson(restaurantEntity)
    val result = gson.fromJson(json, SearchedRestaurantEntity::class.java)
    return result.copy(restaurantName = restaurantEntity.restaurantName ?: "null", restaurantId = restaurantEntity.restaurantId ?: -1, imgUrl1 = restaurantEntity.imgUrl1 ?: "null", regionCode = restaurantEntity.regionCode.toString(), restaurantType = restaurantEntity.restaurantType ?: "null", reviewCount = restaurantEntity.reviewCount.toString(), website = restaurantEntity.website ?: "null")
}

fun SearchedRestaurantEntity.Companion.fromRestaurantApiModel(models: List<RestaurantResponseDto>): List<SearchedRestaurantEntity> {
    return models
        .map { it ->
            SearchedRestaurantEntity.fromRestaurantApiModel(it)
        }
}