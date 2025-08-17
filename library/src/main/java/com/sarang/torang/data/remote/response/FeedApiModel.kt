package com.sarang.torang.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sarang.torang.data.entity.FeedEntity
import com.sarang.torang.data.entity.MyFeedEntity

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

fun FeedApiModel.toFeedEntity(): FeedEntity {
    return FeedEntity(
        reviewId = reviewId,
        userId = user.userId,
        contents = contents,
        rating = rating,
        userName = user.userName,
        likeAmount = like_amount,
        commentAmount = comment_amount,
        restaurantName = restaurant.restaurantName,
        restaurantId = restaurant.restaurantId,
        createDate = this.create_date,
        profilePicUrl = this.user.profilePicUrl
    )
}

