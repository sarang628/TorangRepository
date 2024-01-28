package com.sarang.torang.datasource

import com.sarang.torang.data.ReviewImage


/**
 * 내 리뷰화면에서 필요한 로컬데이터
 * - 원격 저징소에서 데이터 가져오기 실패했을 때 캐시데이터
 */
interface MyReviewsLocalDataSource {
    suspend fun getMyReviews() : List<ReviewImage>
}