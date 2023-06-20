package com.sryang.torang_repository.data.remote.response

import com.google.gson.annotations.SerializedName

data class RemoteFeed(
    @SerializedName("review_id")
    val reviewId: Int,
    val pictures: List<RemotePicture>,
    var medias: ArrayList<RemoteAdMedia>?,
    var restaurant: RemoteRestaurant?,
    val user: RemoteUser?,
    var contents: String?,
    var create_date: String?,
    var rating: Float?,
    var like: LikeResponse?,
    var favorite: FavoriteResponse?,
    val comment_amount: Int?,
    val like_amount: Int?
)
