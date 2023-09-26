package com.sryang.torang_repository.data.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.sryang.torang_repository.data.Review
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

data class ReviewAndImageEntity(
    @Embedded val review: FeedEntity,
    @Relation(
        parentColumn = "reviewId",
        entityColumn = "reviewId"
    )
    val images: List<ReviewImageEntity>,

    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val user: UserEntity
) {
    fun toFeedEntity(): FeedEntity {
        TODO("Not yet implemented")
    }

    companion object {
        fun parse(result: Review): ReviewAndImageEntity {
            TODO("Not yet implemented")
        }
    }
}

fun ReviewAndImageEntity.toMap(): HashMap<String, RequestBody> {
    val params: HashMap<String, RequestBody> = HashMap()
    params["review_id"] =
        RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review.reviewId)
    params["torang_id"] =
        RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review.restaurantId)
    user?.userId?.let {
        params["user_id"] = RequestBody.create("text/plain".toMediaTypeOrNull(), "" + it)
    }
    params["contents"] =
        RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review.contents)
    params["rating"] = RequestBody.create("text/plain".toMediaTypeOrNull(), "" + review.rating)
    return params
}