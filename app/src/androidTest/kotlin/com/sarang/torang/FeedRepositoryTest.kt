package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiFeed
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.LoginRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class FeedRepositoryTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var feedRepository: FeedRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun loadFeedWithPageTest() = runTest {
        feedRepository.loadFeedWithPage(1)
    }

    @Test
    fun loadUserAllFeedsByReviewIdTest() = runTest {
        feedRepository.loadUserAllFeedsByReviewId(425)
    }

    @Test
    fun addLikeTest() = runTest {
        feedRepository.addLike(425)
    }


}