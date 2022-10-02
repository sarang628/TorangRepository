package com.sryang.torang_repository.data.entity

import androidx.room.Embedded
import androidx.room.Relation
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

data class ReviewAndImageEntity(
    @Embedded val review: FeedEntity,
    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val images: List<ReviewImageEntity>? = null,

    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val user: UserEntity? = null
) {
    fun toMap(): HashMap<String, RequestBody> {
        val params: HashMap<String, RequestBody> = HashMap()
        params["review_id"] =
            RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review?.review_id)
        params["torang_id"] =
            RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review?.restaurantId)
        user?.userId?.let {
            params["user_id"] = RequestBody.create("text/plain".toMediaTypeOrNull(), "" + it)
        }
        params["contents"] =
            RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review?.contents)
        params["rating"] = RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review?.rating)
        return params
    }
}


fun ReviewAndImageEntity.toFeedEntity(): FeedEntity {
    return FeedEntity(
        userId = user!!.userId,
        review_id = review!!.review_id
    )
}
