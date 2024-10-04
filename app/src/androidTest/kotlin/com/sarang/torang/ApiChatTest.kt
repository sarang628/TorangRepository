package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiChat
import com.sarang.torang.api.ApiFeed
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.session.SessionService
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
class ApiChatTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiChat: ApiChat

    @Inject
    lateinit var loginRepository: LoginRepository

    @Inject
    lateinit var chatRepository: ChatRepository

    @Inject
    lateinit var sessionService: SessionService

    @Before
    fun setUp() = runTest {
        hiltRule.inject()

        loginRepository.encEmailLogin("sry_ang@naver.com", "Torang!234")
    }

    @Test
    fun getChatRoomTest() = runTest {
        val result = apiChat.getChatRoom(sessionService.getToken()!!)
        Assert.assertEquals(result.isNotEmpty(), true)
        Assert.assertEquals(result[0].users[0].userName.isNotEmpty(), true)
    }

    @Test
    fun getContentsTest() = runTest {
        apiChat.getContents(sessionService.getToken()!!, 1)
    }

    @Test
    fun createChatRoomTest() = runTest {
        val result = chatRepository.getUserOrCreateRoomByUserId(2)
        Assert.assertEquals(result, "")
    }

    @Test
    fun addChatTest() = runTest {
        chatRepository.addChat(roomId = 26, message = "hi")
    }
}