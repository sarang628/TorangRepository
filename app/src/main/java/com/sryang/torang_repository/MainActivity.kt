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
import com.sryang.torang_repository.api.ApiReviewTest
import com.sryang.torang_repository.data.dao.FavoriteDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.TestLoggedInUserDao
import com.sryang.torang_repository.di.repository.api.ApiRestaurantTest
import com.sryang.torang_repository.repository.EditProfileRepository
import com.sryang.torang_repository.repository.FeedRepository
import com.sryang.torang_repository.repository.FeedRepositoryTest
import com.sryang.torang_repository.repository.FollowRepository
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.LoginRepositoryTest
import com.sryang.torang_repository.repository.MapRepository
import com.sryang.torang_repository.repository.ProfileRepository
import com.sryang.torang_repository.repository.ProfileRepositoryTest
import com.sryang.torang_repository.repository.ReportRepository
import com.sryang.torang_repository.repository.SettingsRepository
import com.sryang.torang_repository.repository.TestFollowRepository
import com.sryang.torang_repository.repository.TestReportRepository
import com.sryang.torang_repository.session.SessionClientService
import com.sryang.torang_repository.session.SessionService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    @Inject lateinit var apiFeed: ApiFeed //
    //    @Inject
    //    lateinit var remoteReviewService: RemoteReviewService
    //
    //    @Inject
    //    lateinit var remoteDataSource: FeedRemoteDataSource

    @Inject lateinit var feedRepository: FeedRepository

    @Inject lateinit var profileRepository: ProfileRepository

    @Inject lateinit var apiRestaurant: ApiRestaurant

    @Inject lateinit var apiComment: ApiComment

    @Inject lateinit var favoriteDao: FavoriteDao

    @Inject lateinit var editProfileRepository: EditProfileRepository

    @Inject lateinit var sessionService: SessionService

    @Inject lateinit var sessionClientService: SessionClientService

    @Inject lateinit var loginRepository: LoginRepository

    @Inject lateinit var apiReview: ApiReview

    @Inject lateinit var apiAlarm: ApiAlarm

    @Inject lateinit var settingRepository: SettingsRepository

    @Inject lateinit var mapRepository: MapRepository

    @Inject lateinit var loggedInUserDao: LoggedInUserDao

    @Inject lateinit var followRepository: FollowRepository

    @Inject lateinit var reportRepository: ReportRepository

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.verticalScroll(rememberScrollState())) {/*Column(Modifier.weight(1f)) {
                    FeedRepositoryTest(feedRepository = feedRepository)
                }
                Column(Modifier.weight(1f)) {
                    FavoriteDaoTest(feedDao = favoriteDao)
                }*/ //FavoriteTest(apiFeed = apiFeed)
                //LikeTest(apiFeed = apiFeed)
                //ApiCommentTest(apiComment = apiComment, sessionService = sessionService)
                //ApiFeedTest(apiFeed)
                //ReviewServiceTest(remoteReviewService = remoteReviewService)
                //FeedRepositoryTest(feedRepository = feedRepository) //ProfileRepositoryTest(profileRepository = profileRepository)
//                ApiRestaurantTest(apiRestaurant = apiRestaurant)
                //EditProfileRepositoryTest(editProfileRepository = editProfileRepository)
                //LoginRepositoryTest(loginRepository = loginRepository)
                //SessionClientServiceTest(sessionClientService = sessionClientService)
                ApiReviewTest(apiReview = apiReview)
                //ApiAlarmTest(apiAlarm = apiAlarm, sessionService)
                //SettingRepositoryTest(settingRepository)
                //MapRepositoryTest(mapRepository = mapRepository)
                //TestLoggedInUserDao(loggedInUserDao = loggedInUserDao)
                //TestFollowRepository(followRepository = followRepository)
                //LoginRepositoryTest(loginRepository = loginRepository)
//                TestReportRepository(reportRepository = reportRepository)
            }
        }
    }
}