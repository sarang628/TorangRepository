package com.sryang.torang_repository.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sryang.torang_core.data.entity.*
import java.lang.Exception
import java.text.ParseException

data class FeedResponse(
    @SerializedName("review_id")
    val reviewId: Int,
    var user: User,
    var restaurant: Restaurant,
    var pictures: ArrayList<Picture>,
    var medias: ArrayList<AdMedia>,
    var contents: String,
    var rating: Float,
    var like: Like,
    var favorite: Favorite,
    val comment_amount: Int,
    val like_amount: Int,
    val isFavority: Boolean,
    var create_date: String,
) {
    fun hasMedia(): Boolean {
        return false
    }

    fun validate() {

    }
}

fun FeedResponse.toUser(): User {
    return User(
        userName = user.userName,
        userId = user.userId,
        email = user.email,
        loginPlatform = user.loginPlatform,
        createDate = user.loginPlatform,
        accessToken = user.accessToken,
        profilePicUrl = user.profilePicUrl,
        point = user.point,
        reviewCount = user.reviewCount,
        followers = user.followers,
        following = user.following,
        isFollow = false
    )
}

fun FeedResponse.toFeed(): Feed {
    try {
        return Feed(
            author = toUser(),
            review = toReview(),
            like = toLike(),
            favorite = toFavorite(),
            comment = toComment(),
            likeAmount = like_amount,
            commentAmount = comment_amount,
        )
    } catch (e: Exception) {
        throw ParseException("", 0)
    }
}

fun FeedResponse.toReview(): Review {
    return Review(
        userId = user.userId,
        restaurantId = restaurant.restaurantId,
        reviewId = reviewId,
        selectedImagePath = ArrayList(),
        pictures = ArrayList(),
        restaurant = toRestaurant(),
        user = toUser(),
        contents = contents,
        createDate = create_date,
        likeAmount = like_amount,
        like = toLike(),
        ratings = this.rating
    )
}

fun FeedResponse.toLike(): Like {
    return Like(
        likeId = 0,
        isLike = false
    )
}

fun FeedResponse.toRestaurant(): Restaurant {
    return Restaurant(
        restaurantId = 0,
        restaurantName = "",
        address = "",
        lat = 0.0,
        lon = 0.0,
        rating = 0f,
        tel = "",
        prices = Prices.NONE,
        restaurantType = RestaurantType.NONE,
        regionCode = 0,
        reviewCount = 0,
        site = "",
        website = "",
        imgUrl1 = "",
        imgUrl2 = "",
        imgUrl3 = "",
        imgUrl4 = "",
        imgUrl5 = "",
        imgUrl6 = "",
        pictureList = ArrayList()
    )
}

fun FeedResponse.toFavorite(): Favorite {
    return Favorite(
        favorityId = 0,
        isFavority = false
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