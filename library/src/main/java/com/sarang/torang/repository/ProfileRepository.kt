package com.sarang.torang.repository

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AssistChip
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
import com.google.gson.GsonBuilder
import com.sarang.torang.api.handle
import com.sarang.torang.data.entity.FavoriteEntity
import com.sarang.torang.data.entity.ReviewAndImageEntity
import com.sarang.torang.data.entity.ReviewImageEntity
import com.sarang.torang.data.remote.response.RemoteUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

interface ProfileRepository {
    suspend fun loadProfile(userId: Int): RemoteUser
    suspend fun loadProfileByToken(): RemoteUser
    fun getMyFeed(userId: Int): Flow<List<ReviewAndImageEntity>>
    fun getMyFavorite(userId: Int): Flow<List<ReviewAndImageEntity>>
    suspend fun loadMyFeed(userId: Int)
    val isLogin: Flow<Boolean> get() = MutableStateFlow(false)
    fun getFavorite(reviewId: Int): Flow<FavoriteEntity>
    fun getReviewImages(reviewId: Int): Flow<List<ReviewImageEntity>>
}

@Composable
fun ProfileRepositoryTest(profileRepository: ProfileRepository) {
    var profile by remember { mutableStateOf("b") }
    var isProgress by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }

    Column {
        Box {
            Column {
                HorizontalDivider(color = Color.LightGray)
                Text(text = "ProfileRepositoryTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Column {
                    AssistChip(
                        label = { Text(text = "loadProfile 1") },
                        onClick = {
                            coroutine.launch {
                                isProgress = true
                                val result = profileRepository.loadProfile(1)
                                profile = GsonBuilder().setPrettyPrinting().create().toJson(result)
                                isProgress = false
                            }
                        })
                    AssistChip(label = { Text(text = "loadProfileByToken") }, onClick = {
                        coroutine.launch {
                            isProgress = true
                            try {
                                val result = profileRepository.loadProfileByToken()
                                profile = GsonBuilder().setPrettyPrinting().create().toJson(result)
                            } catch (e: Exception) {
                                profile = e.handle()
                            } finally {
                                isProgress = false
                            }
                        }
                    })
                    AssistChip(
                        label = { Text(text = "getMyFeed") },
                        onClick = {
                            coroutine.launch {
                                try {
                                    profileRepository.loadMyFeed(32)
                                } catch (e: Exception) {
                                    error = e.message ?: ""
                                }
                            }
                        })
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
