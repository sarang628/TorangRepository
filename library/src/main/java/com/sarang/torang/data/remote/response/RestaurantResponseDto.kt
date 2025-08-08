package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sarang.torang.data.Restaurant

// @formatter:off
data class RestaurantResponseDto(
    @SerializedName("restaurant_id")        val restaurantId    : Int,
    @SerializedName("restaurant_name")      val restaurantName  : String,
    @SerializedName("address")              val address         : String,
    @SerializedName("lat")                  val lat             : Double,
    @SerializedName("lon")                  val lon             : Double,
    @SerializedName("rating")               val rating          : Float,
    @SerializedName("tel")                  val tel             : String,
    @SerializedName("prices")               val prices          : String,
    @SerializedName("restaurant_type")      val restaurantType  : String,
    @SerializedName("region_code")          val regionCode      : Int,
    @SerializedName("review_count")         val reviewCount     : Int,
    @SerializedName("site")                 val site            : String,
    @SerializedName("website")              val website         : String,
    @SerializedName("img_url1")             val imgUrl1         : String,
    @SerializedName("img_url2")             val imgUrl2         : String,
    @SerializedName("img_url3")             val imgUrl3         : String,
    @SerializedName("img_url4")             val imgUrl4         : String,
    @SerializedName("img_url5")             val imgUrl5         : String,
    @SerializedName("img_url6")             val imgUrl6         : String,
    @SerializedName("restaurant_type_cd")   val restaurantTypeCd: String
)

fun RestaurantResponseDto.toEntity() : Restaurant{
    return Restaurant(restaurantId = restaurantId, restaurantName = restaurantName, address = address, lat = lat, lon = lon, rating = rating, tel = tel, prices = prices, restaurantType = restaurantType, regionCode = regionCode, reviewCount = reviewCount, site = site, website = website, imgUrl1 = imgUrl1)
}
// @formatter:on