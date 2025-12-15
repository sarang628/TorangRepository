package com.sarang.torang.data

data class Feed(
    val reviewId        : Int       = -1,
    val userId          : Int?      = null,
    val restaurantId    : Int?      = null,
    val userName        : String?   = null,
    val restaurantName  : String?   = null,
    val profilePicUrl   : String?   = null,
    val contents        : String?   = null,
    val rating          : Float?    = null,
    val likeAmount      : Int?      = null,
    val commentAmount   : Int?      = null,
    val createDate      : String?   = null
){
    companion object
}
