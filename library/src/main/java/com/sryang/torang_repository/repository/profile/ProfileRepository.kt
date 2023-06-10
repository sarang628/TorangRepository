package com.sryang.torang_repository.repository.profile

import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.UserEntity
import com.sryang.torang_repository.repository.feed.FeedListRepository
import kotlinx.coroutines.flow.Flow

interface ProfileRepository : FeedListRepository {
    fun getMyProfile(): Flow<LoggedInUserEntity?>
    fun loadProfile(userId: Int): Flow<UserEntity>
    fun getMyFeed(userId: Int): Flow<List<FeedEntity>>
    fun getMyFavorite(userId: Int): Flow<List<FeedEntity>>
    suspend fun logout()
}