package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiLogin
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class LoginTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiLogin: ApiLogin

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun loginTest() = runTest {
        apiLogin.emailLogin("sarang628@naver.com", "aaaaa")
    }
}