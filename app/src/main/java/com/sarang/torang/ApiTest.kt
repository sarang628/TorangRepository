package com.sarang.torang

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiCommentLike
import com.sarang.torang.api.ApiCommentLikeTest
import com.sarang.torang.api.ApiCommentTest
import com.sarang.torang.api.ApiFeed
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.api.ApiReviewTest
import com.sarang.torang.di.repository.api.ApiRestaurantTest
import com.sarang.torang.session.SessionClientService
import com.sarang.torang.session.SessionService

@Composable
fun ApiTest(
    apiFeed: ApiFeed? = null,
    apiComment: ApiComment? = null,
    sessionService: SessionService? = null,
    apiRestaurant: ApiRestaurant? = null,
    apiReview: ApiReview? = null,
    apiAlarm: ApiAlarm? = null,
    apiCommentLike: ApiCommentLike? = null,
    sessionClientService: SessionClientService? = null
) {
    Column {
//        ApiFeedFavoriteTest(apiFeed = apiFeed)
//        ApiFeedLikeTest(apiFeed = apiFeed)
        apiComment?.let {
            ApiCommentTest(apiComment = it, sessionService = sessionService)
        }
//        ApiFeedTest(apiFeed)
        apiRestaurant?.let {
            ApiRestaurantTest(apiRestaurant = it)
        }
//        apiReview?.let { ApiReviewTest(apiReview = apiReview) }
        //ApiAlarmTest(apiAlarm = apiAlarm, sessionService)
        apiCommentLike?.let {
            ApiCommentLikeTest(
                apiCommentLike = apiCommentLike,
                sessionClientService = sessionClientService
            )
        }
    }
}