package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.sarang.torang.data.remote.response.RestaurantApiModel

@Entity
data class SearchedRestaurantEntity(
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
    val website: String,
    val imgUrl1: String,
) {
    companion object
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

fun SearchedRestaurantEntity.Companion.fromRestaurantApiModel(restaurantEntity: RestaurantApiModel): SearchedRestaurantEntity {
    val gson = Gson()
    val json = gson.toJson(restaurantEntity)
    val result = gson.fromJson(json, SearchedRestaurantEntity::class.java)
    return result.copy(restaurantName = restaurantEntity.restaurantName, restaurantId = restaurantEntity.restaurantId, imgUrl1 = restaurantEntity.imgUrl1, regionCode = restaurantEntity.regionCode.toString(), restaurantType = restaurantEntity.restaurantType, reviewCount = restaurantEntity.reviewCount.toString(), website = restaurantEntity.website)
}

fun SearchedRestaurantEntity.Companion.fromRestaurantApiModel(models: List<RestaurantApiModel>): List<SearchedRestaurantEntity> {
    return models
        .map { it ->
            SearchedRestaurantEntity.fromRestaurantApiModel(it)
        }
}