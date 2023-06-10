package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.data.remote.response.RemotePicture
import kotlin.streams.toList


@Entity
data class ReviewImageEntity(
    @PrimaryKey val picture_id: Int,
    val restaurant_id: Int,
    val user_id: Int,
    val review_id: Int,
    val picture_url: String,
    val create_date: String,
    val menu_id: Int,
    val menu: Int
) {
    fun getPictureUrl() {

    }

    companion object {


        /*fun parse(picture: Picture): ReviewImageEntity {
            return ReviewImageEntity(
                picture_id = picture.pictureId,
                restaurant_id = picture.restaurantId,
                review_id = picture.reviewId,
                picture_url = picture.pictureUrl,
                create_date = picture.createDate,
                menu_id = picture.menuId,
                menu = 0,
                user_id = picture.userId
            )
        }*/

        fun uploadParam(path: String): ReviewImageEntity {
            return ReviewImageEntity(
                picture_id = -1,
                restaurant_id = -1,
                review_id = -1,
                picture_url = path,
                create_date = "",
                menu_id = -1,
                menu = 0,
                user_id = -1
            )
        }
    }

    fun RemoteFeed.toPictureEntityList(): List<ReviewImageEntity> {
        return pictures.stream().map {
            it.toPictureEntity()
        }.toList()
    }

    fun RemotePicture.toPictureEntity(): ReviewImageEntity {
        return ReviewImageEntity(
            picture_id = picture_id,
            restaurant_id = restaurant_id,
            user_id = user_id,
            review_id = review_id,
            picture_url = picture_url,
            create_date = create_date,
            menu_id = menu_id,
            menu = menu.toInt()
        )
    }
}