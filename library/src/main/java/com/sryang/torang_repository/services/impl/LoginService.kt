package com.sryang.torang_repository.services.impl

import android.content.Context
import android.util.Log
import android.widget.Toast
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
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginService @Inject constructor(
    private val torangOkhttpClient: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    //private var url = "http://sarang628.iptime.org:8081/"
    private var url = "http://192.168.0.14:8081/"
    fun create(): LoginService {
        return retrofitModule.getRetrofit(torangOkhttpClient.getHttpClient(), url).create(
            LoginService::class.java
        )
    }
}

fun getLoginService(context: Context): LoginService {
    return LoginService(
        torangOkhttpClient = TorangOkHttpClientImpl(context),
        retrofitModule = RetrofitModule()
    ).create()
}

@Preview
@Composable
fun LoginServiceTest() {
    val loginService = getLoginService(LocalContext.current)
    var loginResult by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current

    Column {
        TextField(value = email, onValueChange = { email = it })
        TextField(value = password, onValueChange = { password = it })
        Button(onClick = {
            coroutine.launch {
                try {
                    //loginResult =
                    val result = loginService.emailLogin(email, password)
                    result.body()?.let {
                        Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                        Log.d("__sryang", it.toString())
                    }

                } catch (e: HttpException) {
                    e.response()?.errorBody()?.string()?.let {
                        loginResult = it
                    }
                } catch (e: Exception) {
                    loginResult = e.toString()
                }
            }
        }) {
            Text(text = "test")
        }

        Text(text = loginResult)
    }
}
