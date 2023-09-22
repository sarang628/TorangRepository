package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sryang.torang_repository.data.remote.response.RemoteFeed

@Entity
data class FeedEntity(
    @PrimaryKey
    val reviewId: Int = -1,
    val userId: Int,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean,
    @ColumnInfo(name = "contents") val contents: String,
    @ColumnInfo(name = "create_date") val createDate: String,
    @ColumnInfo(name = "rating") val rating: Float,
    @ColumnInfo(name = "userName") val userName: String,
    @ColumnInfo(name = "profile_pic_url") val profilePicUrl: String,
    @ColumnInfo(name = "like_amount") val likeAmount: Int,
    @ColumnInfo(name = "comment_amount") val commentAmount: Int,
    @ColumnInfo(name = "restaurant_name") val restaurantName: String,
    @ColumnInfo(name = "restaurant_id") val restaurantId: Int
)

fun RemoteFeed.toFeedEntity(): FeedEntity {
    return FeedEntity(
        reviewId = reviewId,
        userId = user?.userId ?: 0,
        isFavorite = favorite != null,
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