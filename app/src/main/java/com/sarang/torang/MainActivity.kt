package com.sarang.torang

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiCommentLike
import com.sarang.torang.api.ApiLike
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.api.feed.ApiFeed
import com.sarang.torang.core.database.dao.FavoriteDao
import com.sarang.torang.core.database.dao.LoggedInUserDao
import com.sarang.torang.core.database.dao.ReviewDao
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.EditProfileRepository
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.FindRepository
import com.sarang.torang.repository.FollowRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.LoginRepositoryTest
import com.sarang.torang.repository.MapRepository
import com.sarang.torang.repository.PicturesRepository
import com.sarang.torang.repository.ProfileRepository
import com.sarang.torang.repository.ReportRepository
import com.sarang.torang.repository.RestaurantRepository
import com.sarang.torang.repository.SettingsRepository
import com.sarang.torang.repository.comment.CommentRepository
import com.sarang.torang.repository.review.ReviewRepository
import com.sarang.torang.repository.test.ChatRepositoryTest
import com.sarang.torang.session.SessionClientService
import com.sarang.torang.session.SessionService
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// @formatter:off
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //daos
    @Inject lateinit var favoriteDao        : FavoriteDao
    @Inject lateinit var loggedInUserDao    : LoggedInUserDao
    @Inject lateinit var reviewDao          : ReviewDao
    //repositories
    @Inject lateinit var feedRepository         : FeedRepository
    @Inject lateinit var profileRepository      : ProfileRepository
    @Inject lateinit var editProfileRepository  : EditProfileRepository
    @Inject lateinit var loginRepository        : LoginRepository
    @Inject lateinit var settingRepository      : SettingsRepository
    @Inject lateinit var mapRepository          : MapRepository
    @Inject lateinit var followRepository       : FollowRepository
    @Inject lateinit var reportRepository       : ReportRepository
    @Inject lateinit var reviewRepository       : ReviewRepository
    @Inject lateinit var commentRepository      : CommentRepository
    @Inject lateinit var picturesRepository     : PicturesRepository
    @Inject lateinit var chatRepository         : ChatRepository
    @Inject lateinit var restaurantRepository   : RestaurantRepository
    @Inject lateinit var findRepository         : FindRepository
    //services
    @Inject lateinit var sessionService         : SessionService
    @Inject lateinit var sessionClientService   : SessionClientService

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    RepositoryNavigation(
                        chatRepository = chatRepository,
                        loginRepository = loginRepository
                    )
                    //Column(Modifier.verticalScroll(rememberScrollState())) {
                        //RepositoryTest(
                    //commentRepository = commentRepository,
                    //feedRepository = feedRepository,
                    //profileRepository = profileRepository,
                    //editProfileRepository = editProfileRepository,
                    //loginRepository = loginRepository,
                    //settingRepository = settingRepository,
                    //mapRepository = mapRepository,
                    //followRepository = followRepository,
                    //reportRepository = reportRepository,
                    //reviewRepository = reviewRepository,
                    //picturesRepository = picturesRepository,
                    //restaurantRepository = restaurantRepository,
                    //findRepository = findRepository
                        //) {

                        //}
                //DaoTest(
                    //favoriteDao = favoriteDao,
                    //loggedInUserDao = loggedInUserDao,
                    //reviewDao = reviewDao
                //)
                        //SessionClientServiceTest(sessionClientService = sessionClientService)
} } } }

    @Composable
    fun RepositoryNavigation(
        chatRepository : ChatRepository,
        loginRepository: LoginRepository
    ){
        val navController = rememberNavController()
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController, startDestination = "menu"){
            composable("menu"){
                Column() {
                    Button({ navController.navigate("ChatRepositoryTest") }) { Text("ChatRepositoryTest") }
                    Button({ navController.navigate("LoginRepositoryTest") }) { Text("LoginRepositoryTest") }
                }

            }
            composable("ChatRepositoryTest") {
                ChatRepositoryTest(
                    loginRepository = loginRepository,
                    chatRepository = chatRepository,
                    image = provideTorangAsyncImage()) { show, onHidden, onSend -> }
            }

            composable("LoginRepositoryTest") {
                LoginRepositoryTest(loginRepository = loginRepository)
            }
        }
    }

}