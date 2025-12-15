package com.sarang.torang.data

data class ReviewAndImage(
    val review: Feed,
    val images: List<ReviewImage>,
    val like: Like?,
    val favorite: Favorite?
){
    companion object
}
