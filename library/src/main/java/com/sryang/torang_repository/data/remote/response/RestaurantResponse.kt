package com.sryang.torang_repository.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sryang.torang_core.data.entity.Prices
import com.sryang.torang_core.data.entity.RestaurantType

data class RestaurantResponse(
    @SerializedName("restaurant_id")
    val restaurantId: Int?,
    @SerializedName("restaurant_name")
    val restaurantName: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("rating")
    val rating: Float?,
    @SerializedName("tel")
    val tel: String?,
    @SerializedName("prices")
    val prices: Prices?,
    @SerializedName("restaurantType")
    val restaurantType: RestaurantType?,
    @SerializedName("region_code")
    val regionCode: Int?,
    @SerializedName("review_count")
    val reviewCount: Int?,
    @SerializedName("site")
    val site: String?,
    @SerializedName("website")
    val website: String?,
    @SerializedName("img_url1")
    val imgUrl1: String?,
    @SerializedName("img_url2")
    val imgUrl2: String?,
    @SerializedName("img_url3")
    val imgUrl3: String?,
    @SerializedName("img_url4")
    val imgUrl4: String?,
    @SerializedName("img_url5")
    val imgUrl5: String?,
    @SerializedName("img_url6")
    val imgUrl6: String?
)