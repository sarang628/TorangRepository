package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    fun getLoginUser() : Flow<LoggedInUserEntity?>
    suspend fun setLoggedInUser(LoggedInUserEntity: LoggedInUserEntity)
}