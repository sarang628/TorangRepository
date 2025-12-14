package com.sarang.torang.repository

import com.sarang.torang.core.database.model.favorite.FavoriteAndImageEntity
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.core.database.model.image.ReviewImageEntity
import com.sarang.torang.core.database.model.like.LikeAndImageEntity
import kotlinx.coroutines.flow.Flow


interface FeedRepository {
    val feeds                                                           : Flow<List<ReviewAndImageEntity>?>
    suspend fun loadByUserId        (userId: Int)
    suspend fun loadById            (reviewId: Int, count: Int = 20)
    suspend fun loadByPage          (page: Int)
    suspend fun loadByRestaurantId  (restaurantId: Int)
    suspend fun loadByFavorite      ()
    suspend fun loadByLike          ()
            fun findRestaurantFeedsFlow (restaurantId : Int)                : Flow<List<ReviewAndImageEntity>>
            fun findByPictureIdFlow (pictureId : Int)                   : Flow<ReviewAndImageEntity?>
    suspend fun findById            (reviewId: Int)                     : ReviewAndImageEntity
            fun findMyFeedById      (reviewId: Int)                     : Flow<List<ReviewAndImageEntity>>  /** 리뷰 ID 기준으로 이전 피드는 위로 다음 피드는 아래로 줄 수 있도록 */
            fun findByUserIdFlow    (userId: Int)                       : Flow<List<ReviewAndImageEntity>>
            fun findByFavoriteFlow()                                    : Flow<List<FavoriteAndImageEntity>>
            fun findByLikeFlow()                                        : Flow<List<LikeAndImageEntity>>
    suspend fun findAllUserFeedById (reviewId: Int)                                                         /** ID에 해당 사용자의 모든 피드 가져오기 */
    suspend fun findByPictureId     (pictureId: Int)
            fun findReviewImagesFlow     (reviewId: Int)                     : Flow<List<ReviewImageEntity>>
    suspend fun deleteAll           ()
    suspend fun deleteById          (reviewId: Int)

}