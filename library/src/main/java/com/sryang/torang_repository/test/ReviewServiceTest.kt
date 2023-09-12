package com.sryang.torang_repository.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sryang.torang_repository.services.RemoteReviewService
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody


@Composable
fun ReviewServiceTest(remoteReviewService: RemoteReviewService) {
    val coroutine = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }
    Column {
        Button(onClick = {
            try {
                coroutine.launch {
                    message = remoteReviewService.addReview(
                        params = HashMap<String, RequestBody>().apply {
                            put("contents", "aaaa".toRequestBody("text/plain".toMediaTypeOrNull()))
                        }

                    ).toString()
                }
            } catch (e: Exception) {
                message = e.toString()
            }
        }) {

        }
        Text(text = message)
    }

}