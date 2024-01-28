package com.sarang.torang.session

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionService @Inject constructor(@ApplicationContext context: Context) :
    SessionClientService {
    private val pref = context.getSharedPreferences("torang", Context.MODE_PRIVATE)

    suspend fun saveToken(token: String) {
        pref.edit().putString("token", token).apply()
    }

    override fun getToken(): String? {
        return pref.getString("token", null)
    }

    suspend fun removeToken() {
        pref.edit().putString("token", null).apply()
    }
}

@Preview
@Composable
fun TestSessionService() {
    val sessionService = SessionService(LocalContext.current)
    val coroutine = rememberCoroutineScope()

    Column {
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