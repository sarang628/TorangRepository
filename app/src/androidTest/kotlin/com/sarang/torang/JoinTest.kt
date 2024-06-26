package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiJoin
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.handle
import com.sarang.torang.util.Encrypt
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.json.JSONObject
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class JoinTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiJoin: ApiJoin

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testSignUp() = runTest {
        try {
            apiJoin.checkEmail("sry_ang@naver.com", "didtkfkd")
        } catch (e: retrofit2.HttpException) {
            Assert.assertEquals(500, e.code())
            Assert.assertEquals("등록된 이메일 입니다.", e.handle())
        }
    }

    @Test
    fun testConfirmCode() = runTest {
        try {
            apiJoin.confirmCode("token", "123456", "didtkfkd", "sry_ang@naver.com", "didtkfkd")
        } catch (e: retrofit2.HttpException) {
            Assert.assertEquals(500, e.code())
            Assert.assertEquals("등록된 이메일 입니다.", e.handle())
        }
    }
}