package com.sarang.torang.repository.review.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sarang.torang.repository.review.ReviewRepository

@Composable
fun ReviewRepositoryTest(
    reviewRepository: ReviewRepository, gallery: (@Composable (
        onNext: (List<String>) -> Unit
    ) -> Unit)? = null
) {
    Column {
        AddReviewTest(reviewRepository = reviewRepository, gallery = gallery)
        //UpdateReviewTest(reviewRepository = reviewRepository, gallery = gallery)
        //GetReviewTest()
        //DeleteReviewTest(reviewRepository = reviewRepository)
    }
}
