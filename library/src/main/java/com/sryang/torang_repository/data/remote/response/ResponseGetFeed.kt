package com.sryang.torang_repository.data.remote.response

import android.graphics.Picture
import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Favorite
import com.sryang.torang_repository.data.Like
import com.sryang.torang_repository.data.User


data class ResponseGetFeed(
    val isFavority: Boolean = false,
    val review_id: Int = -1,
    val pictures: ArrayList<Picture>? = null,
//    val medias: ArrayList<AdMedia>? = null,
    val restaurant: Restaurant? = null,
    val user: User? = null,
    val contents: String? = null,
    val create_date: String? = null,
    val rating: Float = 0f,
    val like: Like? = null,
    val favorite: Favorite? = null,
    val like_amount: Int = 0
)
