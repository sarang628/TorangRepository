package com.sryang.torang_repository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import com.sryang.torang_repository.api.ApiComment
import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.data.dao.FavoriteDao
import com.sryang.torang_repository.data.dao.FavoriteDaoTest
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.di.repository.api.ApiRestaurantTest
import com.sryang.torang_repository.repository.feed.FeedRepository
import com.sryang.torang_repository.repository.feed.FeedRepositoryTest
import com.sryang.torang_repository.repository.profile.ProfileRepository
import com.sryang.torang_repository.repository.profile.ProfileRepositoryTest
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

    @Inject
    lateinit var favoriteDao: FavoriteDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Column {
                Column(Modifier.weight(1f)) {
                    FeedRepositoryTest(feedRepository = feedRepository)
                }
                Column(Modifier.weight(1f)) {
                    FavoriteDaoTest(feedDao = favoriteDao)
                }
                //FavoriteTest(apiFeed = apiFeed)
                //LikeTest(apiFeed = apiFeed)
                //ApiCommentTest(apiComment = apiComment)
                //ApiFeedTest(apiFeed)
                //ReviewServiceTest(remoteReviewService = remoteReviewService)
                //FeedRepositoryTest(feedRepository = feedRepository)
                //ProfileRepositoryTest(profileRepository = profileRepository)
                //ApiRestaurantTest(apiRestaurant = apiRestaurant)
            }
        }
    }
}