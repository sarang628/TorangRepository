package com.sryang.torang_repository.test

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.gson.GsonBuilder
import com.sryang.torang_repository.api.ApiFeed
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException

@Composable
fun LikeTest(remoteFeedServices: ApiFeed) {
    val scope = rememberCoroutineScope()

    var error: String by remember { mutableStateOf("") }
    var padding: String by remember { mutableStateOf("") }
    var loading: Boolean by remember { mutableStateOf(false) }

    Column {
        Text(text = "FeedServiceTest")
        Button(onClick = {
            if (loading)
                return@Button
            loading = true
            scope.launch {
                try {
                    val result = remoteFeedServices.getFeeds(1)
                    padding = GsonBuilder().setPrettyPrinting().create().toJson(result)
                } catch (e: SSLException) {
                    Log.e("sryang123", e.toString())
                    error = e.toString()
                    loading = false
                } catch (e: SocketTimeoutException) {
                    Log.e("sryang123", e.toString())
                    error = e.toString()
                    loading = false
                } catch (e: HttpException) {
                    Log.e("sryang123", e.toString())
                    error = e.toString()
                    loading = false
                }
            }
        }) {
            if (loading) {
                Text(text = "요청중")
            } else {
                Text(text = "요청하기")
            }
        }
        if (padding.isNotBlank())
            Text(
                text = padding, Modifier.verticalScroll(rememberScrollState())
            )
        if (error.isNotBlank())
            Text(text = error)
        if (loading)
            CircularProgressIndicator()
    }
}