package com.sarang.torang.data

class LikeAndImage(
    var likeId  : Int,
    var reviewId    : Int?      = null,
    var createDate  : String?   = null,
    val pictureId   : Int?      = null,
    val pictureUrl  : String?   = null,
    val width       : Int?      = null,
    val height      : Int?      = null,
){
    companion object
}