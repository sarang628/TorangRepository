package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sryang.torang_core.data.data.Review

@Entity
data class FeedEntity(
    @PrimaryKey
    val review_id: Int = -1,
    @ColumnInfo(name = "user_id") val userId: Int,
    val is_favority: Boolean? = false,
    val contents: String? = null,
    val create_date: String? = null,
    val rating: Float? = 0f,
    val userName: String? = "",
    val profile_pic_url: String? = "",
    val like_amount: Int? = 0,
    val comment_amount: Int? = 0,
    @ColumnInfo(name = "restaurant_name") val restaurantName: String? = "",
    @ColumnInfo(name = "restaurant_id") val restaurantId: Int? = 0
) {
    fun toReview(): Review {
        return Review().apply {
            this.review_id = this@FeedEntity.review_id
        }
    }

    companion object {
        fun parse(reviewAndImage: ReviewAndImageEntity): FeedEntity {
            return FeedEntity(
                userId = reviewAndImage.user!!.userId,
                review_id = reviewAndImage.review!!.review_id
            )
        }
    }
}

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