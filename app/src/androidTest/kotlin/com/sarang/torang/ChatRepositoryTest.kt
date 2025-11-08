package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.comment.CommentRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ChatRepositoryTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var chatRepository: ChatRepository
    @Inject lateinit var loginRepository: LoginRepository
    val tag : String = "ChatRepositoryTest"
    @Before fun setUp() = runTest {
        hiltRule.inject();
        loginRepository.emailLogin("sry_ang@naver.com", "Torang!234")
    }

    @Test
    fun refreshAllChatRoomsTest() = runTest {
        chatRepository.refreshAllChatRooms()
    }

    @Test
    fun getAllChatRoomsFlowTest() = runTest {
        val resultFlow = chatRepository.getAllChatRoomsFlow()

        Log.d(tag, "${resultFlow.first()}")
    }
}