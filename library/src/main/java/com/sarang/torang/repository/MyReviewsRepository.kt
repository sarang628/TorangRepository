package com.sarang.torang.repository

import com.sarang.torang.data.MyReview
import com.sarang.torang.core.database.model.feed.FeedEntity
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import kotlinx.coroutines.flow.Flow

interface MyReviewsRepository {
    @Deprecated("유물", ReplaceWith("getMyReviews2로 바꿔쓰세요", "import?"), DeprecationLevel.WARNING)
    suspend fun getMyReviews(restaurantId: Int): List<ReviewAndImageEntity>

    @Deprecated(
        "유물",
        ReplaceWith("getMyReviews2로 바꿔쓰세요", "import?", "import??"),
        DeprecationLevel.WARNING
    )
    fun getMyReviews1(restaurantId: Int): Flow<List<FeedEntity>>

    // (2022-04-21) 원격 데이터소스와 로컬 데이터소스를 함께 사용해야할 때 Flow를 사용하기 어려움
    suspend fun getMyReviews3(restaurantId: Int): List<MyReview>
}