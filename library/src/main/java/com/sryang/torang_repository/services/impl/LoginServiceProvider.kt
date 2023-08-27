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
import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Filter
import com.sryang.torang_repository.di.RetrofitModule
import com.sryang.torang_repository.di.TorangOkHttpClientImpl
import com.sryang.torang_repository.di.TorangOkhttpClient
import com.sryang.torang_repository.services.LoginResult
import com.sryang.torang_repository.services.LoginServiceForRetrofit
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginServiceProvider @Inject constructor(
    private val torangOkhttpClient: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    //private var url = "http://sarang628.iptime.org:8081/"
    private var url = "http://192.168.0.14:8081/"
    fun create1(): LoginServiceForRetrofit {
        return retrofitModule.getRetrofit(torangOkhttpClient.getHttpClient(), url).create(
            LoginServiceForRetrofit::class.java
        )
    }

    fun create(): LoginService {
        val loginServiceForRetrofit = create1()
        return object : LoginService {
            override suspend fun emailLogin(email: String, password: String): LoginResult {
                val response = loginServiceForRetrofit.emailLogin(email, password)

                if (response.body() == null)
                    throw Exception("")
                else
                    return response.body()!!

            }

            override suspend fun join(filter: Filter): ArrayList<Restaurant> {
                TODO("Not yet implemented")
            }
        }
    }
}

interface LoginService {
    suspend fun emailLogin(email: String, password: String): LoginResult
    suspend fun join(filter: Filter): ArrayList<Restaurant>

}

fun getLoginService(context: Context): LoginService {
    return LoginServiceProvider(
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

                    Toast.makeText(context, result.toString(), Toast.LENGTH_SHORT).show()
                    Log.d("__sryang", result.toString())

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
