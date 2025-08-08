package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName

data class FeedApiModel(
    @SerializedName("review_id")
    val reviewId: Int,
    val pictures: List<RemotePicture>,
    var medias: ArrayList<AdMediaApiModel>?,
    var restaurant: RestaurantResponseDto,
    val user: UserApiModel,
    var contents: String,
    var create_date: String,
    var rating: Float,
    var like: LikeApiModel?,
    var favorite: FavoriteApiModel?,
    val comment_amount: Int,
    val like_amount: Int
)
