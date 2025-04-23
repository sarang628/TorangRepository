package com.sarang.torang.repository

import com.sarang.torang.data.remote.response.FollowerApiModel

/**
 * ## Like Repository
 *
 * 좋아요 관련 데이터 제공
 */
interface LikeRepository {
    /**
     * 리뷰의 좋아요한 사용자 리스트
     * @param reviewId review 아이디
     * @return 좋아요한 사용자 리스트
     */
    suspend fun getLikeUserFromReview(reviewId: Int): List<FollowerApiModel>
}