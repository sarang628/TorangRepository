package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.entity.LoggedInUserEntity

interface SessionRepository {
    fun getLoginUser() : LiveData<LoggedInUserEntity?>
    suspend fun setLoggedInUser(LoggedInUserEntity: LoggedInUserEntity)
}