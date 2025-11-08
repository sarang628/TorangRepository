package com.sarang.torang.repository.test

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.api.handle
import com.sarang.torang.data.User
import com.sarang.torang.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginRepositoryMock(
    override val isLogin: Flow<Boolean> = MutableStateFlow(false),
    override val loginUser: Flow<User?> = MutableStateFlow(null)
) : LoginRepository {
    override fun getUserName(): Flow<String> { TODO("Not yet implemented") }

    override suspend fun emailLogin(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun sessionCheck(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun checkEmail(email: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun confirmCode(
        token: String,
        confirmCode: String,
        name: String,
        email: String,
        password: String
    ): Boolean {
        TODO("Not yet implemented")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LoginRepositoryTest(loginRepository: LoginRepository = LoginRepositoryMock()) {
    val coroutine   : CoroutineScope = rememberCoroutineScope()
    var error       : String         by remember { mutableStateOf("") }
    var success     : String         by remember { mutableStateOf("") }
    val isLogin     : Boolean        by loginRepository.isLogin.collectAsState(false)
    var id          : String         by remember { mutableStateOf("sry_ang@naver.com") }
    var pw          : String         by remember { mutableStateOf("Torang!234") }
    val dispatcher  : OnBackPressedDispatcher? = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Scaffold(topBar = {
        TopAppBar(title = {Text("LoginRepositoryTest")},
            navigationIcon = {
                IconButton({
                    coroutine.launch {
                        dispatcher?.onBackPressed()
                    }
                }) { Icon(Icons.AutoMirrored.Default.ArrowBack, null) }
            }) },
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp)
    ) {
        Column(Modifier.padding(it)) {
            if (!isLogin) {
                OutlinedTextField(value = id, onValueChange = { id = it })
                OutlinedTextField(value = pw, onValueChange = { pw = it })
                Button(onClick = {
                    coroutine.launch {
                        try {
                            loginRepository.emailLogin(id, pw).toString()
                            error = ""
                            success = "로그인에 성공하였습니다."
                        } catch (e: Exception) {
                            success = ""
                            error = e.message.toString()
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
                    try {
                        success = loginRepository.sessionCheck().toString()
                    } catch (e: HttpException) {
                        error = "$e : ${e.handle()}"
                    }
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
            HorizontalDivider(color = Color.LightGray)
        }
    }
}