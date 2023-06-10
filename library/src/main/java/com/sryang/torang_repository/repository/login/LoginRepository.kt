package com.sryang.torang_repository.repository.login

import com.sryang.torang_repository.data.User
import com.sryang.torang_repository.repository.SessionRepository
import kotlinx.coroutines.flow.Flow

interface LoginRepository : SessionRepository {
    suspend fun isLogin(): Boolean
    suspend fun facebookLogin(token: String): User?
    fun isLoginFlow() : Flow<Int>
}