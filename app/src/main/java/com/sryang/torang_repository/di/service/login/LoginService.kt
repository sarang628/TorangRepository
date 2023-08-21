package com.sryang.torang_repository.di.service.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sryang.torang_repository.di.RetrofitModule
import com.sryang.torang_repository.di.TorangOkHttpClientImpl
import com.sryang.torang_repository.di.TorangOkhttpClient
import com.sryang.torang_repository.services.LoginService
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginService @Inject constructor(
    private val torangOkhttpClient: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://sarang628.iptime.org:8081/"
    fun create(): LoginService {
        return retrofitModule.getRetrofit(torangOkhttpClient.getHttpClient(), url).create(
            LoginService::class.java
        )
    }
}

@Preview
@Composable
fun LoginServiceTest() {
    val loginService = LoginService(
        torangOkhttpClient = TorangOkHttpClientImpl(LocalContext.current),
        retrofitModule = RetrofitModule()
    ).create()

    var loginResult by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutine = rememberCoroutineScope()

    Column {
        TextField(value = email, onValueChange = { email = it })
        TextField(value = password, onValueChange = { password = it })
        Button(onClick = {
            coroutine.launch {
                loginResult = loginService.emailLogin(email, password).toString()
            }
        }) {
            Text(text = "test")
        }

        Text(text = loginResult)
    }
}
