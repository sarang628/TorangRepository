package com.sarang.torang.data

data class FavoriteAndImage(
    val favoriteId  : Int,
    val reviewId    : Int?      = null,
    val createDate  : String?   = null,
    val pictureId   : Int?      = null,
    val pictureUrl  : String?   = null,
    val width       : Int?      = null,
    val height      : Int?      = null,
){
    companion object
}