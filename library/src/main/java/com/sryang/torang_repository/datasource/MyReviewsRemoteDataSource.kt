package com.sryang.torang_repository.datasource

import com.sryang.torang_repository.data.entity.ReviewImageEntity

/**
 * 내 리뷰화면에서 필요한 원격 데이터
 * - 내 리뷰 데이터
 */
interface MyReviewsRemoteDataSource {
    suspend fun getMyReviews() : List<ReviewImageEntity>
}