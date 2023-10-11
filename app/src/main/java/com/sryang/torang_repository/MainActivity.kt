package com.sryang.torang_repository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sryang.torang_repository.api.ApiComment
import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.di.repository.api.ApiRestaurantTest
import com.sryang.torang_repository.repository.feed.FeedRepository
import com.sryang.torang_repository.repository.profile.ProfileRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var apiFeed: ApiFeed
//
//    @Inject
//    lateinit var remoteReviewService: RemoteReviewService
//
//    @Inject
//    lateinit var remoteDataSource: FeedRemoteDataSource

    @Inject
    lateinit var feedRepository: FeedRepository

    @Inject
    lateinit var profileRepository: ProfileRepository

    @Inject
    lateinit var apiRestaurant: ApiRestaurant

    @Inject
    lateinit var apiComment: ApiComment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            //FavoriteTest(apiFeed = apiFeed)
            //LikeTest(apiFeed = apiFeed)
            //FeedRepositoryTest(feedRepository = feedRepository)
            //ApiCommentTest(apiComment = apiComment)
            //ApiFeedTest(apiFeed)
            //ReviewServiceTest(remoteReviewService = remoteReviewService)
            //FeedRepositoryTest(feedRepository = feedRepository)
            //ProfileRepositoryTest(profileRepository = profileRepository)
            ApiRestaurantTest(apiRestaurant = apiRestaurant)
            //TestApiRestaurant(apiRestaurant = apiRestaurant)
        }
    }
}