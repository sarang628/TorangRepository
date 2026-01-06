package com.sarang.torang.repository.feed

import com.sarang.torang.data.ReviewAndImage
import kotlinx.coroutines.flow.Flow

interface FeedLoadRepository {
    val feeds                                                           : Flow<List<ReviewAndImage>?>
    suspend fun loadByUserId        (userId: Int)
    suspend fun loadById            (reviewId: Int, count: Int = 20)
    suspend fun loadById            (reviewId: Int)
    suspend fun loadByPage          (page: Int)
    suspend fun loadByRestaurantId  (restaurantId: Int)
    suspend fun loadByFavorite      ()
    suspend fun loadByLike          ()
    suspend fun loadFeedGird        (reviewId : Int)

    suspend fun setLoadTrigger      (boolean: Boolean)
}