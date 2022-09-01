package com.sryang.torang_core.repository

import com.sryang.torang_core.data.data.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository : SessionRepository {
    suspend fun isLogin(): Boolean
    suspend fun facebookLogin(token: String): User?
    fun isLoginFlow() : Flow<Int>
}