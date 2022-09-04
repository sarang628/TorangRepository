package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.entity.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository : SessionRepository {
    suspend fun isLogin(): Boolean
    suspend fun facebookLogin(token: String): User?
    fun isLoginFlow() : Flow<Int>
}