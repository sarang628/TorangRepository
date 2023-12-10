package com.sryang.torang_repository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import com.sryang.torang_repository.api.ApiAlarm
import com.sryang.torang_repository.api.ApiComment
import com.sryang.torang_repository.api.ApiFeed
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.api.ApiReview
import com.sryang.torang_repository.data.dao.FavoriteDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.ReviewDao
import com.sryang.torang_repository.repository.EditProfileRepository
import com.sryang.torang_repository.repository.FeedRepository
import com.sryang.torang_repository.repository.FollowRepository
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.MapRepository
import com.sryang.torang_repository.repository.ProfileRepository
import com.sryang.torang_repository.repository.ReportRepository
import com.sryang.torang_repository.repository.ReviewRepository
import com.sryang.torang_repository.repository.SettingsRepository
import com.sryang.torang_repository.session.SessionClientService
import com.sryang.torang_repository.session.SessionService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var apiFeed: ApiFeed

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

    @Inject
    lateinit var editProfileRepository: EditProfileRepository

    @Inject
    lateinit var sessionService: SessionService

    @Inject
    lateinit var sessionClientService: SessionClientService

    @Inject
    lateinit var loginRepository: LoginRepository

    @Inject
    lateinit var apiReview: ApiReview

    @Inject
    lateinit var apiAlarm: ApiAlarm

    @Inject
    lateinit var settingRepository: SettingsRepository

    @Inject
    lateinit var mapRepository: MapRepository

    @Inject
    lateinit var loggedInUserDao: LoggedInUserDao

    @Inject
    lateinit var followRepository: FollowRepository

    @Inject
    lateinit var reportRepository: ReportRepository

    @Inject
    lateinit var reviewDao: ReviewDao

    @Inject
    lateinit var reviewRepository : ReviewRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                RepositoryTest(
                    feedRepository = feedRepository,
//                    profileRepository = profileRepository,
//                    editProfileRepository = editProfileRepository,
//                    loginRepository = loginRepository,
//                    settingRepository = settingRepository,
//                    mapRepository = mapRepository,
//                    followRepository = followRepository,
//                    reportRepository = reportRepository,
                    reviewRepository = reviewRepository
                    )
                ApiTest(
//                    apiFeed = apiFeed,
//                    apiComment = apiComment,
//                    sessionService = sessionService,
//                    apiRestaurant = apiRestaurant,
//                    apiReview = apiReview,
//                    apiAlarm = apiAlarm,
                )
                DaoTest(
//                    favoriteDao = favoriteDao,
//                    loggedInUserDao = loggedInUserDao,
//                    reviewDao = reviewDao
                )
                //SessionClientServiceTest(sessionClientService = sessionClientService)
            }
        }
    }
}