package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiFilter
import com.sarang.torang.api.ApiLike
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.session.SessionService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ApiLikeTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiLike: ApiLike

    @Inject
    lateinit var loginRepository: LoginRepository

    @Inject
    lateinit var sessionService: SessionService

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun getLikeUserByReviewIdTest() = runTest {
        val result = apiLike.getLikeUserByReviewId(
            auth = "",
            reviewId = "10"
        )
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun getLikeUserByReviewId1Test() = runTest {
        loginRepository.encEmailLogin("sry_ang@naver.com", "Torang!234")

        val result = apiLike.getLikeUserByReviewId(
            auth = sessionService.getToken() ?: "",
            reviewId = "278"
        )
        Assert.assertEquals(result.isNotEmpty(), true)
    }


}