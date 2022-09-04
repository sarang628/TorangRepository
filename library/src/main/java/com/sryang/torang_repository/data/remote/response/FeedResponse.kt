package com.sryang.torang_repository.data.remote.response

import com.sryang.torang_core.data.entity.*

data class FeedResponse(
    val review_id: Int,
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
}

fun FeedResponse.toUser(): User {
    return User(
        userName = "",
        userId = 0,
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
        userId = 0,
        restaurantId = 0,
        reviewId = 0,
        selectedImagePath = ArrayList(),
        pictures = ArrayList(),
        restaurant = toRestaurant(),
        user = toUser(),
        contents = contents,
        createDate = create_date,
        likeAmount = like_amount,
        like = toLike()
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