package com.sryang.torang_repository.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.sryang.torang_repository.api.handle
import com.sryang.torang_repository.data.remote.response.LoginResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

interface LoginRepository {
    suspend fun emailLogin(
        email: String,
        password: String
    ): LoginResponse

    suspend fun logout()

    suspend fun sessionCheck(): Boolean

    val isLogin: StateFlow<Boolean>

    fun getUserName(): Flow<String>
}

@Composable
fun LoginRepositoryTest(loginRepository: LoginRepository) {
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var success by remember { mutableStateOf("") }
    val isLogin by loginRepository.isLogin.collectAsState()
    Column {
        if (!isLogin) {
            Button(onClick = {
                coroutine.launch {
                    try {
                        success =
                            loginRepository.emailLogin("sarang628@naver.com", "1234").toString()
                    } catch (e: Exception) {
                        error = e.handle()
                    }
                }
            }) {
                Text(text = "login", color = Color.White)
            }
        } else {
            Button(onClick = {
                coroutine.launch {
                    loginRepository.logout()
                }
            }) {
                Text(text = "logout", color = Color.White)
            }
        }

        Button(onClick = {
            coroutine.launch {
                success = loginRepository.sessionCheck().toString()
            }
        }) {
            Text(text = "sessionCheck")
        }

        Text(text = error, color = Color.Red)
        Text(text = success, color = Color.Blue)

        Text(text = "isLogin : $isLogin")
    }
}