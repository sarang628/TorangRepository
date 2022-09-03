package com.sryang.torang_repository.data.remote.response

data class FeedResponse(
    val review_id: Int? = -1,
//    var user: User? = null
//    var restaurant: Restaurant? = null
//    var pictures: ArrayList<Picture>? = null
//    var medias: ArrayList<AdMedia>? = null
    var contents: String? = null,
    var rating: Float? = 0f,
//    var like: Like? = null
//    var favorite: Favorite? = null
    val comment_amount: Int? = 0,
    val like_amount: Int? = 0,
    val isFavority: Boolean? = false,
    var create_date: String? = null,
) {
    fun hasMedia(): Boolean {
        return false
    }
}