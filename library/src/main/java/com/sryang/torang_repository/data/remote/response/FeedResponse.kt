package com.sryang.torang_repository.data.remote.response

import com.google.gson.annotations.SerializedName
import com.sryang.torang_core.data.entity.*
import java.text.ParseException

data class FeedResponse(
    @SerializedName("review_id")
    val reviewId: Int,
    var user: UserResponse?,
    var restaurant: RestaurantResponse?,
    var pictures: ArrayList<PictureResponse>?,
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

fun FeedResponse.toUser(): User {
    return User(
        userName = user?.userName ?: "",
        userId = user?.userId ?: 0,
        email = user?.email ?: "",
        loginPlatform = user?.loginPlatform ?: "",
        createDate = user?.createDate ?: "",
        accessToken = "",
        profilePicUrl = user?.profilePicUrl ?: "",
        point = 0,
        reviewCount = user?.reviewCount ?: 0,
        followers = user?.followers ?: 0,
        following = user?.following ?: 0,
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
            likeAmount = like_amount ?: 0,
            commentAmount = comment_amount ?: 0,
            pictures = ArrayList()
        )
    } catch (e: Exception) {
        throw ParseException(e.toString(), 0)
    }
}

fun FeedResponse.toReview(): Review {
    return Review(
        userId = user?.userId ?: 0,
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