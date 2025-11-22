package com.sarang.torang.repository

import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import kotlinx.coroutines.flow.Flow


interface FeedRepository {
    val feeds                                                           : Flow<List<ReviewAndImageEntity>?>
            fun restaurantFeedsFlow (restaurantId : Int)                : Flow<List<ReviewAndImageEntity>>
            fun findByPictureIdFlow (pictureId : Int)                   : Flow<ReviewAndImageEntity?>
    suspend fun findAll             ()
    suspend fun findById            (reviewId: Int)                     : ReviewAndImageEntity
    suspend fun findById            (reviewId: Int, count: Int = 20)
    suspend fun findByPage          (page: Int)
            fun findMyFeedById      (reviewId: Int)                     : Flow<List<ReviewAndImageEntity>>  /** 리뷰 ID 기준으로 이전 피드는 위로 다음 피드는 아래로 줄 수 있도록 */
    suspend fun findByRestaurantId  (restaurantId: Int)
    suspend fun findByPictureId     (pictureId: Int)
    suspend fun findAllUserFeedById (reviewId: Int)                                                         /** ID에 해당 사용자의 모든 피드 가져오기 */
    suspend fun deleteAll           ()
    suspend fun deleteById          (reviewId: Int)
    suspend fun loadFeedByRestaurantId(restaurantId: Int)
}