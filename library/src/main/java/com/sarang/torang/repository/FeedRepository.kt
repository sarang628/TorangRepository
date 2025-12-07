package com.sarang.torang.repository

import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.core.database.model.image.ReviewImageEntity
import kotlinx.coroutines.flow.Flow


interface FeedRepository {
    val feeds                                                           : Flow<List<ReviewAndImageEntity>?>
            fun restaurantFeedsFlow (restaurantId : Int)                : Flow<List<ReviewAndImageEntity>>
            fun findByPictureIdFlow (pictureId : Int)                   : Flow<ReviewAndImageEntity?>
    suspend fun findById            (reviewId: Int)                     : ReviewAndImageEntity
            fun findMyFeedById      (reviewId: Int)                     : Flow<List<ReviewAndImageEntity>>  /** 리뷰 ID 기준으로 이전 피드는 위로 다음 피드는 아래로 줄 수 있도록 */
            fun findByUserIdFlow    (userId: Int)                       : Flow<List<ReviewAndImageEntity>>
            fun findByFavoriteFlow()                                    : Flow<List<ReviewAndImageEntity>>
            fun findByLikeFlow()                                        : Flow<List<ReviewAndImageEntity>>
    suspend fun findAllUserFeedById (reviewId: Int)                                                         /** ID에 해당 사용자의 모든 피드 가져오기 */
    suspend fun findByPictureId     (pictureId: Int)
    suspend fun loadByUserId        (userId: Int)
    suspend fun loadById            (reviewId: Int, count: Int = 20)
    suspend fun loadByPage          (page: Int)
    suspend fun loadByRestaurantId  (restaurantId: Int)
    suspend fun loadByFavorite      ()
    suspend fun loadByLike          ()
    suspend fun deleteAll           ()
    suspend fun deleteById          (reviewId: Int)
            fun getReviewImages     (reviewId: Int)                     : Flow<List<ReviewImageEntity>>
}