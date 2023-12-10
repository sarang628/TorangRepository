package com.sryang.torang_repository

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sarang.instagralleryModule.GalleryNavHost
import com.sarang.instagralleryModule.activity.InstagramGalleryContract
import com.sarang.instagralleryModule.compose.PreviewGalleryGridView
import com.sarang.instagralleryModule.compose.PreviewGalleryScreen
import com.sryang.torang_repository.repository.EditProfileRepository
import com.sryang.torang_repository.repository.FeedRepository
import com.sryang.torang_repository.repository.FeedRepositoryTest
import com.sryang.torang_repository.repository.FollowRepository
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.LoginRepositoryTest
import com.sryang.torang_repository.repository.MapRepository
import com.sryang.torang_repository.repository.ProfileRepository
import com.sryang.torang_repository.repository.ReportRepository
import com.sryang.torang_repository.repository.ReviewRepository
import com.sryang.torang_repository.repository.ReviewRepositoryTest
import com.sryang.torang_repository.repository.SettingsRepository

@Composable
fun RepositoryTest(
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