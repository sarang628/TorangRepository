package com.sryang.torang_repository.repository

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.Filter
import com.sryang.torang_repository.data.remote.response.LoginResult
import com.sryang.torang_repository.session.SessionService
import kotlinx.coroutines.launch
import retrofit2.HttpException


interface LoginService {
    suspend fun emailLogin(email: String, password: String): LoginResult
    suspend fun join(filter: Filter): ArrayList<Restaurant>

}


@Composable
fun LoginServiceTest(loginService: LoginService) {
    val sessionService = SessionService(LocalContext.current)
    var loginResult by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current
    val isLogin by sessionService.isLogin.collectAsState()

    Column {
        TextField(value = email, onValueChange = { email = it })
        TextField(value = password, onValueChange = { password = it })
        Button(onClick = {
            coroutine.launch {
                try {
                    //loginResult =
                    val result = loginService.emailLogin(email, password)

                    Toast.makeText(context, result.toString(), Toast.LENGTH_SHORT).show()
                    Log.d("__sryang", result.toString())
                    sessionService.saveToken(result.token)

                } catch (e: HttpException) {
                    e.response()?.errorBody()?.string()?.let {
                        loginResult = it
                    }
                } catch (e: Exception) {
                    loginResult = e.toString()
                }
            }
        }) {
            Text(text = "Login")
        }
        Button(onClick = {
            //sessionService.removeToken()
        }) {
            Text(text = "Logout")
        }
        Text(text = loginResult)

        Text(text = "Token:${sessionService.getToken()}")

        IsLogin(isLogin = isLogin)
    }
}

@Composable
fun IsLogin(isLogin: Boolean) {
    Text(text = isLogin.toString())
}
