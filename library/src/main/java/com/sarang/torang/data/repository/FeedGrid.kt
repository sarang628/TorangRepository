package com.sarang.torang.data.repository

data class FeedGrid(
    val reviewId    : Int,
    val pictureId   : Int?      = null,
    val pictureUrl  : String?   = null,
    val width       : Int?      = null,
    val height      : Int?      = null,
){
    companion object
}