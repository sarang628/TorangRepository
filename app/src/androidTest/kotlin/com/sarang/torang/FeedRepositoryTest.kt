package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.core.database.dao.LikeDao
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.LikeRepository
import com.sarang.torang.repository.LoginRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
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

    @Inject lateinit var feedRepository: FeedRepository
    @Inject lateinit var likeRepository: LikeRepository
    @Inject lateinit var loginRepository: LoginRepository

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        loginRepository.emailLogin("sry_ang@naver.com","Torang!234")
        //feedRepository.findAll()
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
    fun loadNextFeedByReivewIdTest() = runTest {
        feedRepository.findById(471)

        assertEquals(true, feedRepository.feeds.first()?.any { it.review.reviewId == 471 })
    }

    @Test
    fun findByPictureIdTest() = runTest {
        val result = feedRepository.findByPictureIdFlow(1005)
            .first()

        assertEquals(true, result != null)
    }

    @Test
    fun likeTest() = runTest {
        // 피드 첫번째 아이템 '좋아요 테스트' 대상으로 선택
        val firstReview = feedRepository.feeds.first()?.get(0)?.review ?: run {
            throw Exception("feeds is null")
        }

        // 우선 좋아요가 있으면 삭제
        likeRepository.deleteLike(firstReview.reviewId)

        // 피드 첫번째 아이템 다시 가져오기
        var review = feedRepository.feeds
            .first()
            ?.firstOrNull { it.review.reviewId == firstReview.reviewId }
            ?: throw Exception("review is null")

        // 좋아요 아님 확인
        assertEquals(null, review.like)

        // 좋아요 추가
        likeRepository.addLike(reviewId = review.review.reviewId)

        // 피드 첫번째 아이템 다시 가져오기
        review = feedRepository.feeds
            .first()
            ?.firstOrNull { it.review.reviewId == firstReview.reviewId}
            ?: throw Exception("review is null")

        // 좋아요 추가 확인
        assertEquals(true, review.like != null)
    }

    @Test
    fun getByRestaurantIdTest() = runTest {

        // 음식점 리뷰 저장하기
        feedRepository.findByRestaurantId(299)

        val feedsFlow = feedRepository.restaurantFeedsFlow(299)

        assertEquals(false, feedsFlow.first().isEmpty())

        assertEquals(false, feedsFlow.first().none { it.like != null })

        /*if(feedsFlow.first()[0].like == null)
            likeRepository.addLike(feedsFlow.first()[0].review.reviewId)*/

    }

}