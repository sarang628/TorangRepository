package com.sryang.torang_repository.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
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

    suspend fun checkEmail(email: String, password: String): String
    suspend fun confirmCode(
        token: String,
        confirmCode: String,
        name: String,
        email: String,
        password: String
    ): Boolean
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
                            loginRepository.emailLogin("sarang628@naver.com", "aaaaa").toString()
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

        Button(onClick = {
            coroutine.launch {
                try {
                    success = loginRepository.checkEmail("sarang628@gmail.com", "11111")
                } catch (e: Exception) {
                    error = e.message.toString()
                }
            }
        }) {
            Text(text = "SignUp")
        }

        Button(onClick = {
            coroutine.launch {
                try {
                    success = loginRepository.confirmCode(
                        token = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjExMTExIiwianRpIjoiOTY4ODE0Iiwic3ViIjoic2FyYW5nNjI4QGdtYWlsLmNvbSIsImlhdCI6MTY5ODk5MTEwNCwiZXhwIjoxNjk4OTk0NzA0fQ.BRvZ_v234_74UaWCxUl8LYBXn559i_r-DPahq-nzOtY",
                        confirmCode = "968814",
                        email = "sarang628@gmail.com", password = "11111", name = "aab"
                    ).toString()
                } catch (e: Exception) {
                    error = e.message.toString()
                }
            }
        }) {
            Text(text = "confirmCode")
        }

        Text(text = error, color = Color.Red)
        Text(text = success, color = Color.Blue)

        Text(text = "isLogin : $isLogin")
    }
}