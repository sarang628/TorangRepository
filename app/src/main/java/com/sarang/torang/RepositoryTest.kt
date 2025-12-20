package com.sarang.torang

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sarang.torang.repository.EditProfileRepository
import com.sarang.torang.repository.feed.FeedRepository
import com.sarang.torang.repository.FindRepository
import com.sarang.torang.repository.FollowRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.test.LoginRepositoryTest
import com.sarang.torang.repository.MapRepository
import com.sarang.torang.repository.PicturesRepository
import com.sarang.torang.repository.UserRepository
import com.sarang.torang.repository.ReportRepository
import com.sarang.torang.repository.RestaurantRepository
import com.sarang.torang.repository.SettingsRepository
import com.sarang.torang.repository.comment.CommentRepository
import com.sarang.torang.repository.comment.compose.CommentRepositoryTest
import com.sarang.torang.repository.review.ReviewRepository
import com.sarang.torang.repository.review.compose.ReviewRepositoryTest
import com.sarang.torang.repository.test.EditProfileRepositoryTest
import com.sarang.torang.repository.test.FeedRepositoryTest
import com.sarang.torang.repository.test.FindRepositoryTest
import com.sarang.torang.repository.test.PicturesRepositoryTest
import com.sarang.torang.repository.test.ProfileRepositoryTest
import com.sarang.torang.repository.test.RestaurantRepositoryTest
import com.sarang.torang.repository.test.TestFollowRepository

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun RepositoryTest(
    commentRepository: CommentRepository? = null,
    feedRepository: FeedRepository? = null,
    profileRepository: UserRepository? = null,
    editProfileRepository: EditProfileRepository? = null,
    loginRepository: LoginRepository? = null,
    settingRepository: SettingsRepository? = null,
    mapRepository: MapRepository? = null,
    followRepository: FollowRepository? = null,
    reportRepository: ReportRepository? = null,
    reviewRepository: ReviewRepository? = null,
    picturesRepository: PicturesRepository? = null,
    restaurantRepository: RestaurantRepository? = null,
    findRepository: FindRepository? = null,
    content: @Composable () -> Unit = {},
) {
    Column {
        content.invoke()
        commentRepository?.let { CommentRepositoryTest(commentRepository = it) }
        profileRepository?.let { ProfileRepositoryTest(profileRepository = it) }
        editProfileRepository?.let { EditProfileRepositoryTest(editProfileRepository = it) }
        loginRepository?.let { LoginRepositoryTest(loginRepository = it) }
        //SettingRepositoryTest(settingRepository)
        //MapRepositoryTest(mapRepository = mapRepository)
        followRepository?.let { TestFollowRepository(followRepository = it) }
        //LoginRepositoryTest(loginRepository = loginRepository)
        //TestReportRepository(reportRepository = reportRepository)
        reviewRepository?.let { ReviewRepositoryTest(reviewRepository = it, gallery = { onNext -> }) }
        picturesRepository?.let { PicturesRepositoryTest(repository = it) }
        restaurantRepository?.let { RestaurantRepositoryTest(restaurantRepository = it) }
    }
}