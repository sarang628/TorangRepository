package com.sarang.torang.repository

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sarang.torang.api.handle
import com.sarang.torang.data.entity.ReviewAndImageEntity
import com.sarang.torang.data.remote.response.RemoteUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

interface ProfileRepository : FeedListRepository {
    suspend fun loadProfile(userId: Int): RemoteUser
    suspend fun loadProfileByToken(): RemoteUser
    fun getMyFeed(userId: Int): Flow<List<ReviewAndImageEntity>>
    fun getMyFavorite(userId: Int): Flow<List<ReviewAndImageEntity>>
    suspend fun loadMyFeed(userId: Int)

    override val isLogin: Flow<Boolean>
        get() = MutableStateFlow(false)
}

@Composable
fun ProfileRepositoryTest(profileRepository: ProfileRepository) {
//    var profile by remember { mutableStateOf(UserEntity(userId = 0, userName = "!®")) }
    var profile by remember { mutableStateOf("b") }
    var isProgress by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }

    Column {
        Box {
            Column {
                HorizontalDivider(color = Color.LightGray)
                Text(text = "ProfileRepositoryTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Row {
                    Button(onClick = {
                        coroutine.launch {
                            isProgress = true
                            val result = profileRepository.loadProfile(1)
                            profile = result.toString()
                            isProgress = false
                        }
                    }) {
                        Text(text = "loadProfile 1")
                    }

                    Button(onClick = {
                        coroutine.launch {
                            isProgress = true
                            try {
                                val result = profileRepository.loadProfileByToken()
                                profile = result.toString()
                            } catch (e: Exception) {
                                profile = e.handle()
                            } finally {
                                isProgress = false
                            }
                        }
                    }) {
                        Text(text = "loadProfileByToken")
                    }
                    Button(onClick = {
                        coroutine.launch {
                            try {
                                profileRepository.loadMyFeed(32)
                            } catch (e: Exception) {
                                error = e.message ?: ""
                            }
                        }
                    }) {
                        Text(text = "getMyFeed")
                    }
                }
                Text(
                    text = profile
                )
                Text(text = error)
            }
            if (isProgress)
                CircularProgressIndicator()
        }
    }
}
