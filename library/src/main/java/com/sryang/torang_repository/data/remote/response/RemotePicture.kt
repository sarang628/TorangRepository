package com.sryang.torang_repository.data.remote.response

import com.sryang.torang_repository.data.entity.ReviewImageEntity

data class RemotePicture(
    val picture_id: Int,
    val restaurant_id: Int,
    val user_id: Int,
    val review_id: Int,
    val picture_url: String,
    val create_date: String,
    val menu_id: Int,
    val menu: String
)

fun RemotePicture.toReviewImage(): ReviewImageEntity {
    return ReviewImageEntity(
        picture_id = this.picture_id,
        restaurantId = this.restaurant_id,
        userId = this.user_id,
        reviewId = this.review_id,
        pictureUrl = this.picture_url,
        createDate = this.create_date,
        menuId = this.menu_id,
        menu = 1
    )
}