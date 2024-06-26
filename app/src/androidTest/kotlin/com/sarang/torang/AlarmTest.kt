package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.handle
import com.sarang.torang.util.Encrypt
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
class AlarmTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiAlarm: ApiAlarm

    @Inject
    lateinit var apiLogin: ApiLogin

    var token = ""

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        token = apiLogin.emailLogin("sry_ang@naver.com", Encrypt.encrypt("didtkfkd")).token
    }

    @Test
    fun testGetAlarms() = runTest {
        apiAlarm.getAlarms(token)
    }

    @Test
    fun testGetAlarms1() = runTest {
        try {
            apiAlarm.getAlarms("auth")
        } catch (e: retrofit2.HttpException) {
            Assert.assertEquals(500, e.code())
            Assert.assertEquals("인증에 실패하였습니다.", e.handle())
        }
    }
}