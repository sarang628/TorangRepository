package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.samples.apps.sunflower.ui.TorangTheme
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiCommentLike
import com.sarang.torang.api.ApiFeed
import com.sarang.torang.api.ApiLike
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.data.dao.FavoriteDao
import com.sarang.torang.data.dao.LoggedInUserDao
import com.sarang.torang.data.dao.ReviewDao
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.comment.CommentRepository
import com.sarang.torang.repository.EditProfileRepository
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.FollowRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.MapRepository
import com.sarang.torang.repository.PicturesRepository
import com.sarang.torang.repository.ProfileRepository
import com.sarang.torang.repository.ReportRepository
import com.sarang.torang.repository.RestaurantRepository
import com.sarang.torang.repository.review.ReviewRepository
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
    lateinit var reviewRepository: ReviewRepository

    @Inject
    lateinit var commentRepository: CommentRepository

    @Inject
    lateinit var apiCommentLike: ApiCommentLike

    @Inject
    lateinit var picturesRepository: PicturesRepository

    @Inject
    lateinit var restaurantRepository: RestaurantRepository

    @Inject
    lateinit var chatRepository: ChatRepository

    @Inject
    lateinit var apiLike: ApiLike

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column(Modifier.verticalScroll(rememberScrollState())) {

                        RepositoryTest(
//                    commentRepository = commentRepository,
//                            feedRepository = feedRepository,
//                    profileRepository = profileRepository,
//                    editProfileRepository = editProfileRepository,
                            loginRepository = loginRepository,
//                    settingRepository = settingRepository,
//                    mapRepository = mapRepository,
//                    followRepository = followRepository,
//                    reportRepository = reportRepository,
//                    reviewRepository = reviewRepository,
//                    picturesRepository = picturesRepository,
//                    restaurantRepository = restaurantRepository,
                            chatRepository = chatRepository
                        )
                        ApiTest(
//                    apiLike = apiLike,
//                    apiFeed = apiFeed,
//                    apiComment = apiComment,
                            sessionService = sessionService,
//                    apiRestaurant = apiRestaurant,
//                    apiReview = apiReview,
//                            apiAlarm = apiAlarm,
//                    apiCommentLike = apiCommentLike,
//                    sessionClientService = sessionClientService
                        )
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
    }
}