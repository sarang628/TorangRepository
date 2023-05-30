package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sryang.torang_repository.Restaurant

/**
 *     "address": "",
"lat": 10.3192061,
"lon": 123.9048379,
"rating": 0.0,
"tel": "",
"prices": "AROUND_30K",
"restaurant_type": "KOREAN",
"region_code": 0,
"review_count": 1,
"site": null,
"website": null,
"img_url1": "https://media-cdn.tripadvisor.com/media/photo-s/01/a0/4d/20/when-we-dropped-by.jpg",
"img_url2": "",
"img_url3": "",
"img_url4": "",
"img_url5": "",
"img_url6": ""
 */
@Entity
data class RestaurantEntity(
    @PrimaryKey val restaurant_id: Int,
    val restaurant_name: String,
    val lat: Double? = null,
    val lon: Double? = null,
    val rating: Float? = null,
    val tel: String? = null,
    val prices: String? = null,
    val restaurant_type: String? = null,
    val region_code: String? = null,
    val review_count: String? = null,
    val site: String? = null,
    val website: String? = null,
    val img_url1: String? = null,
    val img_url2: String? = null,
    val img_url3: String? = null,
    val img_url4: String? = null,
    val img_url5: String? = null,
    val img_url6: String? = null

) {
/*    companion object {
        fun parse(restaurant: Restaurant): RestaurantEntity {
            return RestaurantEntity(
                restaurant_id = restaurant.restaurantId,
                restaurant_name = restaurant.restaurantName,
                lat = restaurant.lat,
                lon = restaurant.lon,
                rating = restaurant.rating,
                tel = restaurant.tel,
                prices = restaurant.prices.toName,
                restaurant_type = RestaurantTypeObject.toName(restaurant.restaurantType),
                region_code = restaurant.regionCode.toString(),
                review_count = restaurant.reviewCount.toString(),
                site = restaurant.site,
                website = restaurant.website,
                img_url1 = restaurant.imgUrl1
            )
        }
    }*/
}
