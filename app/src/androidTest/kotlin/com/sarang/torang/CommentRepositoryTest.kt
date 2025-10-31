package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.comment.CommentRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class CommentRepositoryTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var commentRepository: CommentRepository
    @Inject lateinit var loginRepository: LoginRepository
    @Before fun setUp() = runTest { hiltRule.inject(); loginRepository.emailLogin("sry_ang@naver.com", "Torang!234") }

    @Test
    fun loadRestaurantTest() = runTest {
        var result = commentRepository.getComment(626)

        assertTrue(result.profilePicUrl.isNotEmpty())
    }
}