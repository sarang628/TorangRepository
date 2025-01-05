package com.sarang.torang.api.feed

import android.util.Log
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
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException

@Composable
fun ApiFeedFavoriteTest(apiFeed: ApiFeed) {
    val scope = rememberCoroutineScope()

    var error: String by remember { mutableStateOf("") }
    var padding: String by remember { mutableStateOf("") }
    var loading: Boolean by remember { mutableStateOf(false) }

    Column {
        Text(text = "FavoriteTest")
        Button(onClick = {
            if (loading)
                return@Button
            loading = true
            scope.launch {
                try {
                    val result = apiFeed.addFavorite("", 64)
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
                    error = e.response()?.errorBody()?.string() ?: ""
                    loading = false
                }
            }
        }) {
            if (loading) {
                Text(text = "요청중")
            } else {
                Text(text = "즐겨찾기 추가")
            }
        }
        Button(onClick = {
            scope.launch {
                try {
                    val result = apiFeed.deleteFavorite(4)
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
                    error = e.response()?.errorBody()?.string() ?: ""
                    loading = false
                }
            }
        }) {

            if (loading) {
                Text(text = "요청중")
            } else {
                Text(text = "즐겨찾기 삭제")
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