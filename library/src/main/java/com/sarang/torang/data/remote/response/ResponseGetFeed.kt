package com.sarang.torang.data.remote.response

import android.graphics.Picture
import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.RemoteFavorite
import com.sarang.torang.data.RemoteLike
import com.sarang.torang.data.User


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
    val like: RemoteLike? = null,
    val favorite: RemoteFavorite? = null,
    val like_amount: Int = 0
)
