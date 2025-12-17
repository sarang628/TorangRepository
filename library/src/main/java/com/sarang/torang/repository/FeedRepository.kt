package com.sarang.torang.repository

import com.sarang.torang.data.FavoriteAndImage
import com.sarang.torang.data.LikeAndImage
import com.sarang.torang.data.ReviewAndImage
import com.sarang.torang.data.ReviewImage
import kotlinx.coroutines.flow.Flow


interface FeedRepository {
    val feeds                                                           : Flow<List<ReviewAndImage>?>
    suspend fun loadByUserId        (userId: Int)
    suspend fun loadById            (reviewId: Int, count: Int = 20)
    suspend fun loadByPage          (page: Int)
    suspend fun loadByRestaurantId  (restaurantId: Int)
    suspend fun loadByFavorite      ()
    suspend fun loadByLike          ()
            fun findRestaurantFeedsFlow (restaurantId : Int)            : Flow<List<ReviewAndImage>>
            fun findByPictureIdFlow (pictureId : Int)                   : Flow<ReviewAndImage?>
    suspend fun findById            (reviewId: Int)                     : ReviewAndImage
            fun findByIdFlow        (reviewId: Int)                     : Flow<ReviewAndImage?>
            fun findMyFeedById      (reviewId: Int)                     : Flow<List<ReviewAndImage>>  /** 리뷰 ID 기준으로 이전 피드는 위로 다음 피드는 아래로 줄 수 있도록 */
            fun findByUserIdFlow    (userId: Int)                       : Flow<List<ReviewAndImage>>
            fun findByFavoriteFlow()                                    : Flow<List<FavoriteAndImage>>
            fun findByLikeFlow()                                        : Flow<List<LikeAndImage>>
    suspend fun findAllUserFeedById (reviewId: Int)                                                         /** ID에 해당 사용자의 모든 피드 가져오기 */
    suspend fun findByPictureId     (pictureId: Int)
            fun findReviewImagesFlow     (reviewId: Int)                     : Flow<List<ReviewImage>>
    suspend fun deleteAll           ()
    suspend fun deleteById          (reviewId: Int)

}