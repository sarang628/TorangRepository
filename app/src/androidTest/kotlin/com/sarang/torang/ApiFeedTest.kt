package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiFeed
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
class ApiFeedTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

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
    fun checkImageWidthHeight() = runTest {
        val result = apiFeed.getFeeds(null)
        Assert.assertEquals(result[0].pictures[0].width > 0, true)
        Assert.assertEquals(result[0].pictures[0].height > 0, true)
    }

}