package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.RemotePicture


@Entity
data class ReviewImageEntity(
    @PrimaryKey val pictureId: Int,
    val restaurantId: Int,
    val userId: Int,
    val reviewId: Int,
    val pictureUrl: String,
    val createDate: String,
    val menuId: Int,
    val menu: Int
) {
    companion object {
        fun uploadParam(path: String): ReviewImageEntity {
            return ReviewImageEntity(
                pictureId = -1,
                restaurantId = -1,
                reviewId = -1,
                pictureUrl = path,
                createDate = "",
                menuId = -1,
                menu = 0,
                userId = -1
            )
        }
    }

    fun FeedApiModel.toPictureEntityList(): List<ReviewImageEntity> {
        return pictures.stream().map {
            it.toPictureEntity()
        }.toList()
    }

    fun RemotePicture.toPictureEntity(): ReviewImageEntity {
        return ReviewImageEntity(
            pictureId = picture_id,
            restaurantId = restaurant_id,
            userId = user_id,
            reviewId = review_id,
            pictureUrl = picture_url,
            createDate = create_date ?: "",
            menuId = menu_id,
            menu = menu.toInt()
        )
    }
}