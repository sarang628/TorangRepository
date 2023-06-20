package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sryang.torang_repository.data.remote.response.RemoteFeed

@Entity
data class FeedEntity(
    @PrimaryKey
    val review_id: Int = -1,
    val userId: Int,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean? = false,
    @ColumnInfo(name = "contents") val contents: String? = null,
    @ColumnInfo(name = "create_date") val createDate: String? = null,
    @ColumnInfo(name = "rating") val rating: Float? = 0f,
    @ColumnInfo(name = "userName") val userName: String? = "",
    @ColumnInfo(name = "profile_pic_url") val profilePicUrl: String? = "",
    @ColumnInfo(name = "like_amount") val likeAmount: Int? = 0,
    @ColumnInfo(name = "comment_amount") val commentAmount: Int? = 0,
    @ColumnInfo(name = "restaurant_name") val restaurantName: String? = "",
    @ColumnInfo(name = "restaurant_id") val restaurantId: Int? = 0
)

fun RemoteFeed.toFeedEntity(): FeedEntity {
    return FeedEntity(
        review_id = reviewId,
        userId = user?.userId ?: 0,
        isFavorite = favorite != null,
        contents = contents,
        rating = rating,
        userName = user?.userName,
        likeAmount = like_amount,
        commentAmount = comment_amount,
        restaurantName = restaurant?.restaurantName,
        restaurantId = restaurant?.restaurantId
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