package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.repository.FeedRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * runTest를 사용하면 코루틴 안에서 코드를 작성할 수 있다.
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class FeedRepositoryTest {

    private val tag = "__FeedRepositoryTest"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var feedRepository: FeedRepository

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        feedRepository.findAll()
    }

    @Test
    fun loadFeedWithPageTest() = runTest {
        feedRepository.findByPage(1)
    }

    @Test
    fun loadUserAllFeedsByReviewIdTest() = runTest {
        feedRepository.findAllUserFeedById(425)
    }

    @Test
    fun addLikeTest() = runTest {
        //feedRepository.addLike(425)
    }

    @Test
    fun loadNextFeedByReivewIdTest() = runTest {
        feedRepository.findById(471)

        feedRepository.feeds.first {
            println("---------------------------------------------------")
            println(GsonBuilder().setPrettyPrinting().create().toJson(it))
            println("---------------------------------------------------")
            true
        }
    }

    @Test
    fun findByPictureIdTest() = runTest {
        val result = feedRepository.findByPictureIdFlow(1005)
            .first()

        Log.d(tag, result.toString())
    }

}