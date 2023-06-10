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
        restaurant_id = this.restaurant_id,
        user_id = this.user_id,
        review_id = this.review_id,
        picture_url = this.picture_url,
        create_date = this.create_date,
        menu_id = this.menu_id,
        menu = 1
    )
}