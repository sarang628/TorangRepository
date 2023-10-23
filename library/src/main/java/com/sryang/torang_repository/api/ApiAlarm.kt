package com.sryang.torang_repository.api

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sryang.torang_repository.data.RemoteAlarm
import com.sryang.torang_repository.session.SessionService
import kotlinx.coroutines.launch
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiAlarm {
    @POST("getAlarms")
    suspend fun getAlarms(@Header("authorization") auth: String): ArrayList<RemoteAlarm>
}

@Composable
fun ApiAlarmTest(apiAlarm: ApiAlarm, sessionService: SessionService) {
    var result by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()

    Column {
        Button(onClick = {
            coroutine.launch {
                sessionService.getToken()?.let {
                    Log.d("ApiAlarmTest", it)
                    result = apiAlarm.getAlarms(it).toString()
                }
            }
        }) {
            Text(text = "")
        }
        Text(text = result)
    }
}