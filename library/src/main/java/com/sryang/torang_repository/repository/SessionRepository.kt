package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.flow.StateFlow

interface SessionRepository {
    fun getLoginUser() : StateFlow<LoggedInUserEntity?>
    suspend fun setLoggedInUser(LoggedInUserEntity: LoggedInUserEntity)
}