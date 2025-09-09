package com.sarang.torang.repository

import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import kotlinx.coroutines.flow.Flow


interface FeedRepository {
    val feeds: Flow<List<ReviewAndImageEntity>>
    suspend fun findAll()                                                                       /** 모든 피드 가져오기 */
    suspend fun findById(reviewId: Int)                     : ReviewAndImageEntity              /** 리뷰 ID로 피드 가져오기 */
    suspend fun findById(reviewId: Int, count: Int = 20)                                        /** 리뷰 ID 다음 피드 가져오기 */
    suspend fun findByPage(page: Int)                                                           /** 페이지 단위로 피드 가져오기 */
            fun findMyFeedById(reviewId: Int)               : Flow<List<ReviewAndImageEntity>>  /** 리뷰 ID 기준으로 이전 피드는 위로 다음 피드는 아래로 줄 수 있도록 */
            fun findByRestaurantId(restaurantId: Int)       : Flow<List<ReviewAndImageEntity>>  /** 음식점 ID로 피드 가져오기 */
    suspend fun findAllUserFeedById(reviewId: Int)                                              /** ID에 해당 사용자의 모든 피드 가져오기 */
    suspend fun deleteAll()                                                                     /** 모든 피드 삭제 */
    suspend fun deleteById(reviewId: Int)                                                       /** 내 리뷰 삭제 */
}