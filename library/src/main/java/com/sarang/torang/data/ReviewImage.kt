package com.sarang.torang.data

data class ReviewImage(
    val pictureId       : Int,
    val restaurantId    : Int?      = null,
    val userId          : Int?      = null,
    val reviewId        : Int?      = null,
    val pictureUrl      : String?   = null,
    val createDate      : String?   = null,
    val menuId          : Int?      = null,
    val menu            : Int?      = null,
    val width           : Int?      = null,
    val height          : Int?      = null,
    val order           : Int?      = null
){
    companion object
}
