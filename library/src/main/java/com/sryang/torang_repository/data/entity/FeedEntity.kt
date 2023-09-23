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
        userId = user?.userId ?: 0,
        contents = contents ?: "",
        rating = rating ?: 0f,
        userName = user?.userName ?: "",
        likeAmount = like_amount ?: 0,
        commentAmount = comment_amount ?: 0,
        restaurantName = restaurant?.restaurantName ?: "",
        restaurantId = restaurant?.restaurantId ?: 0,
        createDate = this.create_date ?: "",
        profilePicUrl = this.user?.profilePicUrl ?: ""
    )
}


fun FeedEntity.profilePicUrl(): String {
    var url = ""
    profilePicUrl?.let {
        url = it
    }
    return url
}

fun FeedEntity.userName(): String {
    var nm = "";
    userName?.let {
        nm = it
    }
    return nm
}

fun FeedEntity.restaurantName(): String {
    var nm = "";
    restaurantName?.let {
        nm = it
    }
    return nm
}