package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.UserEntity
import kotlinx.coroutines.flow.StateFlow

interface ProfileRepository : FeedListRepository {
    fun getMyProfile(): StateFlow<LoggedInUserEntity?>
    fun loadProfile(userId: Int): StateFlow<UserEntity>
    fun getMyFeed(userId: Int): StateFlow<List<FeedEntity>>
    fun getMyFavorite(userId: Int): StateFlow<List<FeedEntity>>
    suspend fun logout()
}