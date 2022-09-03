package com.sryang.torang_repository.data.remote

import android.os.Build
import androidx.annotation.RequiresApi
import com.sryang.torang_core.data.entity.Feed
import kotlin.streams.toList

data class RemoteFeed(
    val name: String,
    val reviewId: Int,
    val restaurantName: String,
    val rating: Float,
    val profilePictureUrl: String,
    val reviewImages: ArrayList<String>
)

@RequiresApi(Build.VERSION_CODES.N)
fun List<RemoteFeed>.toFeedList(): List<Feed> {
    return stream().map { it.toFeed() }.toList()
}


fun RemoteFeed.toFeed(): Feed {
    return Feed(
        review_id = this.reviewId,
        userId = 0
    )
}