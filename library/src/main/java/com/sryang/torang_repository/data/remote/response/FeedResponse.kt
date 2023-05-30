package com.sryang.torang_repository.data.remote.response

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import com.sryang.torang_repository.data.Feed
import java.text.ParseException
import kotlin.streams.toList

data class FeedResponse(
    @SerializedName("review_id")
    val reviewId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("profile_pic_url")
    val profilePictureUrl: String,
    var restaurant: RestaurantResponse?,
    var pictures: ArrayList<PictureResponse>,
    var medias: ArrayList<AdMediaResponse>?,
    var contents: String?,
    var rating: Float?,
    var like: LikeResponse?,
    var favorite: FavoriteResponse?,
    val comment_amount: Int?,
    val like_amount: Int?,
    val isFavority: Boolean?,
    var create_date: String?,
) {
    fun hasMedia(): Boolean {
        return false
    }

    fun validate() {

    }
}
