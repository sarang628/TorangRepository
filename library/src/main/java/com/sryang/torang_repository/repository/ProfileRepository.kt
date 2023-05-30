package com.sryang.torang_repository.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.UserEntity

interface ProfileRepository : FeedListRepository {
    fun getMyProfile(): LiveData<LoggedInUserEntity?>
    fun loadProfile(userId: Int): LiveData<UserEntity>
    fun getMyFeed(userId: Int): LiveData<List<FeedEntity>>
    fun getMyFavorite(userId: Int): LiveData<List<FeedEntity>>
    suspend fun logout()
}