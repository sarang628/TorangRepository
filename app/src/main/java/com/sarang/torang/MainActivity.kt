package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiFeed
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.data.dao.FavoriteDao
import com.sarang.torang.data.dao.LoggedInUserDao
import com.sarang.torang.data.dao.ReviewDao
import com.sarang.torang.repository.EditProfileRepository
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.FollowRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.MapRepository
import com.sarang.torang.repository.ProfileRepository
import com.sarang.torang.repository.ReportRepository
import com.sarang.torang.repository.ReviewRepository
import com.sarang.torang.repository.SettingsRepository
import com.sarang.torang.session.SessionClientService
import com.sarang.torang.session.SessionService
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
//                    feedRepository = feedRepository,
//                    profileRepository = profileRepository,
//                    editProfileRepository = editProfileRepository,
                    loginRepository = loginRepository,
//                    settingRepository = settingRepository,
//                    mapRepository = mapRepository,
//                    followRepository = followRepository,
//                    reportRepository = reportRepository,
//                    reviewRepository = reviewRepository
                    )
//                ApiTest(
//                    apiFeed = apiFeed,
//                    apiComment = apiComment,
//                    sessionService = sessionService,
//                    apiRestaurant = apiRestaurant,
//                    apiReview = apiReview,
//                    apiAlarm = apiAlarm,
//                )
//                DaoTest(
//                    favoriteDao = favoriteDao,
//                    loggedInUserDao = loggedInUserDao,
//                    reviewDao = reviewDao
//                )
                //SessionClientServiceTest(sessionClientService = sessionClientService)
            }
        }
    }
}