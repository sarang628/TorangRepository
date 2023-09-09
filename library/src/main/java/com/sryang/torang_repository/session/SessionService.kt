package com.sryang.torang_repository.session

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SessionService(context: Context) {
    private val pref = context.getSharedPreferences("torang", Context.MODE_PRIVATE)
    var isLogin = MutableStateFlow(!isEmptyToken())
    var token = MutableStateFlow(getToken())

    suspend fun saveToken(token: String) {
        pref.edit().putString("token", token).apply()
        this@SessionService.token.emit(getToken())
        isLogin.emit(!isEmptyToken())
    }

    fun getToken(): String {
        return pref.getString("token", "")!!
    }

    suspend fun removeToken() {
        pref.edit().putString("token", null).apply()
        this@SessionService.token.emit(getToken())
        isLogin.emit(!isEmptyToken())
    }

    private fun isEmptyToken(): Boolean {
        return getToken() == ""
    }
}

@Preview
@Composable
fun TestSessionService() {
    val sessionService = SessionService(LocalContext.current)
    val isLogin by sessionService.isLogin.collectAsState()
    val coroutine = rememberCoroutineScope()

    Column {
        Text(text = "isLogin = $isLogin")
        Row {
            Button(onClick = {
                coroutine.launch {
                    sessionService.saveToken("savedToken")
                }
            }) {
                Text(text = "save")
            }
            Button(onClick = {
                coroutine.launch {
                    sessionService.removeToken()
                }
            }) {
                Text(text = "delete")
            }
        }

    }
}