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

    @Inject
    lateinit var apiFeed: ApiFeed

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun checkEmailAlreadyRegisteredTest() = runTest {
        val result = apiFeed.getFeeds(null)
        Assert.assertEquals(result.isNotEmpty(), true)
    }

    @Test
    fun getFeedsWithPageTest() = runTest {
        val result = apiFeed.getFeedsWithPage(null, 1)
        Assert.assertEquals(result.isNotEmpty(), true)
    }


    @Test
    fun getFeedByReviewId() = runTest {
        val result = apiFeed.getFeedByReviewId(null, 425)
        Assert.assertEquals(result != null, true)
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