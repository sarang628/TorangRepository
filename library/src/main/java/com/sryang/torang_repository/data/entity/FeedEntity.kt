package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FeedEntity(
    @PrimaryKey
    val review_id: Int = -1,
    val userId: Int,
    @ColumnInfo(name = "is_favority") val is_favority: Boolean? = false,
    @ColumnInfo(name = "contents") val contents: String? = null,
    @ColumnInfo(name = "create_date") val create_date: String? = null,
    @ColumnInfo(name = "rating") val rating: Float? = 0f,
    @ColumnInfo(name = "userName") val userName: String? = "",
    @ColumnInfo(name = "profile_pic_url") val profile_pic_url: String? = "",
    @ColumnInfo(name = "like_amount") val like_amount: Int? = 0,
    @ColumnInfo(name = "comment_amount") val comment_amount: Int? = 0,
    @ColumnInfo(name = "restaurant_name") val restaurantName: String? = "",
    @ColumnInfo(name = "restaurant_id") val restaurantId: Int? = 0
)


fun FeedEntity.profilePicUrl(): String {
    var url = ""
    profile_pic_url?.let {
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