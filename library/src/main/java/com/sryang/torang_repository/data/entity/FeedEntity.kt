package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sryang.torang_repository.data.remote.response.RemoteFeed

@Entity
data class FeedEntity(
    @PrimaryKey
    val reviewId: Int = -1,/* 1 */
    val userId: Int,/* 2 */
    val restaurantId: Int,/* 3 */
    val userName: String,/* 4 */
    val restaurantName: String,/* 5 */
    val profilePicUrl: String,/* 6 */
    val contents: String,/* 7 */
    val rating: Float,/* 8 */
    val likeAmount: Int,/* 9 */
    val commentAmount: Int,/* 10 */
    val createDate: String/* 11 */
)

fun RemoteFeed.toFeedEntity(): FeedEntity {
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