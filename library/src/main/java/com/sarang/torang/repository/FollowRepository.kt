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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TestFollowRepository(followRepository: FollowRepository) {
    val coroutine = rememberCoroutineScope()
    var result by remember { mutableStateOf("") }
    var followerUserId by remember { mutableStateOf("32") }
    var followingUserId by remember { mutableStateOf("32") }
    var followUserId by remember { mutableStateOf("32") }
    var unFollowUserId by remember { mutableStateOf("32") }
    Column {
        HorizontalDivider(color = Color.LightGray)
        Text(text = "FollowRepositoryTest", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        AssistChip(label = {
            Text(text = "myFollower")
        }, onClick = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(followRepository.getMyFollower())
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })
        AssistChip(label = {
            Text(text = "myFollowing")
        }, onClick = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(followRepository.getMyFollowing())
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })
        AssistChip(label = {
            Text(text = "Follow userId: ")
            BasicTextField(value = followUserId, onValueChange = { followUserId = it })
        }, onClick = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(followRepository.follow(followUserId.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })
        AssistChip(label = {
            Text(text = "UnFollow userId: ")
            BasicTextField(value = unFollowUserId, onValueChange = { unFollowUserId = it })
        }, onClick = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(followRepository.unFollow(unFollowUserId.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })

        AssistChip(label = {
            Text(text = "Follower userId: ")
            BasicTextField(value = followerUserId, onValueChange = { followerUserId = it })
        }, onClick = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(followRepository.getFollower(followerUserId.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })
        AssistChip(label = {
            Text(text = "Following userId: ")
            BasicTextField(value = followingUserId, onValueChange = { followingUserId = it })
        }, onClick = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(followRepository.getFollowing(followingUserId.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })
        Text(text = result)
    }
}