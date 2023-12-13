package com.sryang.torang_repository

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sryang.torang_repository.api.ApiAlarm
import com.sryang.torang_repository.api.ApiComment
import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.api.ApiReview
import com.sryang.torang_repository.api.ApiReviewTest
import com.sryang.torang_repository.session.SessionService

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