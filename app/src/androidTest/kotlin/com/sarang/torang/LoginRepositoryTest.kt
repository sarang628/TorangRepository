package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.repository.LoginRepository
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
class LoginRepositoryTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var loginRepository: LoginRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun checkEmailAlreadyRegisteredTest() = runTest {
        try {
            loginRepository.checkEmail("sry_ang@naver.com", "didtkfkd")
        } catch (e: Exception) {
            Assert.assertEquals(e.message, "등록된 이메일 입니다.")
        }
    }


}