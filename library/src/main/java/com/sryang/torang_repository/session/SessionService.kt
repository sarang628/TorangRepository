package com.sryang.torang_repository.session

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionService @Inject constructor(@ApplicationContext context: Context) :
    SessionClientService {
    private val pref = context.getSharedPreferences("torang", Context.MODE_PRIVATE)
    private var _isLogin = MutableStateFlow(false)
    override var isLogin = _isLogin.asStateFlow()

    init {
        getToken()?.let {
            _isLogin.value = true
        }
    }

    suspend fun saveToken(token: String) {
        pref.edit().putString("token", token).apply()
        _isLogin.emit(true)
    }

    override fun getToken(): String? {
        return pref.getString("token", null)
    }

    suspend fun removeToken() {
        pref.edit().putString("token", null).apply()
        _isLogin.emit(false)
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