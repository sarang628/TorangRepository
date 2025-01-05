package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sarang.torang.api.feed.ApiFeed
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

    /**
     * 2025.01 피드(리뷰)를 이미지만 추출, 그리드 형식으로 보여주는 화면을 위한 데이터 제공 기능 구현 테스트
     */
    @Test
    fun getNextReviewsByReviewIdTest() = runTest {
        val result = apiFeed.getNextReviewsByReviewId(null, 471, 30)
        print(GsonBuilder().setPrettyPrinting().create().toJson(result))
        Assert.assertEquals(result.isNotEmpty(), true)
    }
}