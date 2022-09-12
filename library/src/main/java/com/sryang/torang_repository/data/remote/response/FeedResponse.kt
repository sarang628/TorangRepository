package com.sryang.torang_repository.data.remote.response

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import com.sryang.torang_core.data.entity.*
import java.text.ParseException
import kotlin.streams.toList

data class FeedResponse(
    @SerializedName("review_id")
    val reviewId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
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

@RequiresApi(Build.VERSION_CODES.N)
fun FeedResponse.toFeed(): Feed {
    try {
        return Feed(
            author = toUser(),
            review = toReview(),
            like = toLike(),
            favorite = toFavorite(),
            comment = toComment(),
            likeAmount = like_amount ?: 0,
            commentAmount = comment_amount ?: 0,
            pictures = toPictures()
        )
    } catch (e: Exception) {
        throw ParseException(e.toString(), 0)
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun FeedResponse.toPictures(): List<Picture> {
    return pictures.stream().map {
        Picture(
            pictureId = 0,
            pictureUrl = it.picture_url,
            restaurantId = 0,
            userId = 0,
            createDate = "",
            reviewId = 0,
            menuId = 0,
            menu = Menu(
                menu_id = 0,
                restaurant_id = "0",
                menu_name = "",
                menu_price = "",
                menu_pic_url = "",
                rating = 0f,
            )
        )
    }.toList()
}

fun FeedResponse.toUser(): User {
    return User(
        userName = userName,
        userId = userId,
        email = "",
        loginPlatform = "",
        createDate = "",
        accessToken = "",
        profilePicUrl = "",
        point = 0,
        reviewCount = 0,
        followers = 0,
        following = 0,
        isFollow = false
    )
}

fun FeedResponse.toReview(): Review {
    return Review(
        userId = userId,
        restaurantId = restaurant?.restaurantId ?: 0,
        reviewId = reviewId,
        selectedImagePath = ArrayList(),
        pictures = ArrayList(),
        restaurant = toRestaurant(),
        user = toUser(),
        contents = contents ?: "",
        createDate = create_date ?: "",
        likeAmount = like_amount ?: 0,
        like = toLike(),
        ratings = this.rating ?: 0f
    )
}

fun FeedResponse.toLike(): Like {
    return Like(
        likeId = like?.likeId ?: 0,
        isLike = like?.isLike ?: false
    )
}

fun FeedResponse.toRestaurant(): Restaurant {
    return Restaurant(
        restaurantId = restaurant?.restaurantId ?: 0,
        restaurantName = restaurant?.restaurantName ?: "",
        address = restaurant?.address ?: "",
        lat = restaurant?.lat ?: 0.0,
        lon = restaurant?.lon ?: 0.0,
        rating = restaurant?.rating ?: 0f,
        tel = restaurant?.tel ?: "",
        prices = restaurant?.prices ?: Prices.NONE,
        restaurantType = restaurant?.restaurantType ?: RestaurantType.NONE,
        regionCode = restaurant?.regionCode ?: 0,
        reviewCount = restaurant?.reviewCount ?: 0,
        site = restaurant?.site ?: "",
        website = restaurant?.website ?: "",
        imgUrl1 = restaurant?.imgUrl1 ?: "",
        imgUrl2 = restaurant?.imgUrl2 ?: "",
        imgUrl3 = restaurant?.imgUrl3 ?: "",
        imgUrl4 = restaurant?.imgUrl4 ?: "",
        imgUrl5 = restaurant?.imgUrl5 ?: "",
        imgUrl6 = restaurant?.imgUrl6 ?: "",
        pictureList = ArrayList()
    )
}

fun FeedResponse.toFavorite(): Favorite {
    return Favorite(
        favorityId = favorite?.favorityId ?: 0,
        isFavority = favorite?.isFavority ?: false
    )
}

fun FeedResponse.toComment(): Comment {
    return Comment(
        comment_id = 0,
        review_id = 0,
        user = toUser(),
        comment = "",
        createDate = ""
    )
}