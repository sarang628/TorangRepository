package com.sarang.torang.repository.feed

import com.sarang.torang.data.FavoriteAndImage
import com.sarang.torang.data.LikeAndImage
import com.sarang.torang.data.ReviewAndImage
import com.sarang.torang.data.ReviewImage
import com.sarang.torang.data.repository.FeedGrid
import kotlinx.coroutines.flow.Flow

interface FeedFlowRepository {
    fun findRestaurantFeedsFlow (restaurantId : Int) : Flow<List<ReviewAndImage>>
    fun findByPictureIdFlow (pictureId : Int)        : Flow<ReviewAndImage?>
    fun findByIdFlow (reviewId: Int)                 : Flow<ReviewAndImage?>
    fun findMyFeedById (reviewId: Int)               : Flow<List<ReviewAndImage>>
    fun findByUserIdFlow (userId: Int)               : Flow<List<ReviewAndImage>>
    fun findByFavoriteFlow()                         : Flow<List<FavoriteAndImage>>
    fun findByLikeFlow()                             : Flow<List<LikeAndImage>>
    fun findReviewImagesFlow (reviewId: Int)         : Flow<List<ReviewImage>>
    fun findFeedGridFlow()                           : Flow<List<FeedGrid>>
}