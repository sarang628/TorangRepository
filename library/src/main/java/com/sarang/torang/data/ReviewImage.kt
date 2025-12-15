package com.sarang.torang.data

import androidx.room.PrimaryKey

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
){
    companion object
}
