package com.sarang.torang

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiFeed
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.api.ApiReviewTest
import com.sarang.torang.session.SessionService

@Composable
fun ApiTest(
    apiFeed: ApiFeed? = null,
    apiComment: ApiComment? = null,
    sessionService: SessionService? = null,
    apiRestaurant: ApiRestaurant? = null,
    apiReview: ApiReview? = null,
    apiAlarm: ApiAlarm? = null
) {
    Column {
//        ApiFeedFavoriteTest(apiFeed = apiFeed)
//        ApiFeedLikeTest(apiFeed = apiFeed)
//        ApiCommentTest(apiComment = apiComment, sessionService = sessionService)
//        ApiFeedTest(apiFeed)
//                ApiRestaurantTest(apiRestaurant = apiRestaurant)
        apiReview?.let {
            ApiReviewTest(apiReview = apiReview)
        }
        //ApiAlarmTest(apiAlarm = apiAlarm, sessionService)
    }
}