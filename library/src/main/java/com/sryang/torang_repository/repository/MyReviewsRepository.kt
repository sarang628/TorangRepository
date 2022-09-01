package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_core.data.data.MyReview
import com.sryang.torang_repository.data.entity.ReviewAndImageEntity

interface MyReviewsRepository {
    @Deprecated("유물", ReplaceWith("getMyReviews2로 바꿔쓰세요", "import?"), DeprecationLevel.WARNING)
    suspend fun getMyReviews(restaurantId: Int): List<ReviewAndImageEntity>

    @Deprecated(
        "유물",
        ReplaceWith("getMyReviews2로 바꿔쓰세요", "import?", "import??"),
        DeprecationLevel.WARNING
    )
    fun getMyReviews1(restaurantId: Int): LiveData<List<ReviewAndImageEntity>>

    // (2022-04-21) 원격 데이터소스와 로컬 데이터소스를 함께 사용해야할 때 Flow를 사용하기 어려움
    suspend fun getMyReviews3(restaurantId: Int): List<MyReview>
}