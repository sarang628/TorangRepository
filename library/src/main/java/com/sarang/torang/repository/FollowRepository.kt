package com.sarang.torang.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
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
import com.sarang.torang.data.remote.response.RemoteFollower
import kotlinx.coroutines.launch

interface FollowRepository {
    suspend fun getFollower(): List<RemoteFollower>
    suspend fun getFollowing(): List<RemoteFollower>
    suspend fun follow(userId: Int): Boolean
    suspend fun unFollow(userId: Int): Boolean
    suspend fun delete(userId: Int): Boolean
}

@Composable
fun TestFollowRepository(followRepository: FollowRepository) {
    val coroutine = rememberCoroutineScope()
    var result by remember { mutableStateOf("") }
    Column {
        HorizontalDivider(color = Color.LightGray)
        Text(text = "FollowRepositoryTest", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Button(onClick = {
            coroutine.launch {
                try {
                    result = followRepository.getFollower().toString()
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        }) {
            Text(text = "Follower")
        }
        Button(onClick = {
            coroutine.launch {
                try {
                    result = followRepository.getFollowing().toString()
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        }) {
            Text(text = "Following")
        }
        Button(onClick = {
            coroutine.launch {
                try {
                    result = followRepository.follow(1).toString()
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        }) {
            Text(text = "Follow")
        }
        Button(onClick = {
            coroutine.launch {
                try {
                    result = followRepository.unFollow(1).toString()
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        }) {
            Text(text = "UnFollow")
        }
        Text(text = result)
    }
}