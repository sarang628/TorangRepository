package com.sarang.torang.repository.feed

import com.sarang.torang.data.ReviewAndImage

interface FeedRepository {
    suspend fun findById            (reviewId: Int)                     : ReviewAndImage
    suspend fun findAllUserFeedById (reviewId: Int)                                                         /** ID에 해당 사용자의 모든 피드 가져오기 */
    suspend fun findByPictureId     (pictureId: Int)
    suspend fun deleteById          (reviewId: Int)
    suspend fun deleteAll()

}