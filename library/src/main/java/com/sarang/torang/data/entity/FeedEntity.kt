package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sarang.torang.data.remote.response.FeedApiModel

@Entity
data class FeedEntity(
    @PrimaryKey
    val reviewId: Int = -1,
    val userId: Int,
    val restaurantId: Int?,
    val userName: String,
    val restaurantName: String?,
    val profilePicUrl: String,
    val contents: String,
    val rating: Float,
    val likeAmount: Int,
    val commentAmount: Int,
    val createDate: String/* 11 */
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