package com.sarang.torang.repository

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AssistChip
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
import com.sarang.torang.data.remote.response.FollowerApiModel
import kotlinx.coroutines.launch

interface FollowRepository {
    suspend fun getMyFollower(): List<FollowerApiModel>
    suspend fun getFollower(userId: Int): List<FollowerApiModel>
    suspend fun getMyFollowing(): List<FollowerApiModel>
    suspend fun getFollowing(userId: Int): List<FollowerApiModel>
    suspend fun follow(userId: Int): Boolean
    suspend fun unFollow(userId: Int): Boolean
    suspend fun delete(userId: Int): Boolean
}