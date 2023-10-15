package com.sryang.torang_repository.repository.impl

import com.sryang.torang_repository.api.ApiLogin
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.session.SessionService
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val apiLogin: ApiLogin,
    private val sessionService: SessionService
) : LoginRepository {
    override suspend fun emailLogin(
        email: String,
        password: String
    ): String {
        return apiLogin.emailLogin(email = email, password = password).token
    }

    override suspend fun saveToken(token: String) {
        sessionService.saveToken(token)
    }

    override suspend fun logout() {
        sessionService.removeToken()
    }

    override val isLogin: StateFlow<Boolean> get() = sessionService.isLogin

}