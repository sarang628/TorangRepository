package com.sarang.torang

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sarang.instagralleryModule.GalleryNavHost
import com.sarang.torang.repository.comment.CommentRepository
import com.sarang.torang.repository.EditProfileRepository
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.FeedRepositoryTest
import com.sarang.torang.repository.FollowRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.LoginRepositoryTest
import com.sarang.torang.repository.MapRepository
import com.sarang.torang.repository.ProfileRepository
import com.sarang.torang.repository.ReportRepository
import com.sarang.torang.repository.ReviewRepository
import com.sarang.torang.repository.ReviewRepositoryTest
import com.sarang.torang.repository.SettingsRepository
import com.sarang.torang.repository.comment.compose.CommentRepositoryTest

@Composable
fun RepositoryTest(
    commentRepository: CommentRepository? = null,
    feedRepository: FeedRepository? = null,
    profileRepository: ProfileRepository? = null,
    editProfileRepository: EditProfileRepository? = null,
    loginRepository: LoginRepository? = null,
    settingRepository: SettingsRepository? = null,
    mapRepository: MapRepository? = null,
    followRepository: FollowRepository? = null,
    reportRepository: ReportRepository? = null,
    reviewRepository: ReviewRepository? = null
) {
    Column {
        commentRepository?.let {
            CommentRepositoryTest(commentRepository = commentRepository)
        }
        feedRepository?.let {
            FeedRepositoryTest(feedRepository = it)
        }
        //ProfileRepositoryTest(profileRepository = profileRepository)
        //EditProfileRepositoryTest(editProfileRepository = editProfileRepository)
        loginRepository?.let {
            LoginRepositoryTest(loginRepository = loginRepository)
        }
        //SettingRepositoryTest(settingRepository)
        //MapRepositoryTest(mapRepository = mapRepository)
        //TestFollowRepository(followRepository = followRepository)
        //LoginRepositoryTest(loginRepository = loginRepository)
        //TestReportRepository(reportRepository = reportRepository)
        reviewRepository?.let {
            ReviewRepositoryTest(reviewRepository = it, gallery = { onNext ->
                GalleryNavHost(onNext = { onNext.invoke(it) }) {
                }
            })
        }
    }
}