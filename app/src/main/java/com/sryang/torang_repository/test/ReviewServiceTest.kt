package com.sryang.torang_repository.test

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toFile
import com.sryang.torang_repository.api.ApiReview
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException
import java.io.File


@Composable
fun ReviewServiceTest(remoteReviewService: ApiReview) {
    val coroutine = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }
    val context = LocalContext.current

    val file1 = Uri.fromFile(
        File("/storage/emulated/0/DCIM/06 interior/IMG_2082.JPG")
    ).toFile()

    ///storage/emulated/0/DCIM/06 interior/IMG_2082.JPG
    val file = ArrayList<MultipartBody.Part>().apply {
        add(
            MultipartBody.Part.createFormData(
                name = "file",
                filename = file1.name,
                body = file1.asRequestBody()
            )
        )
    }
    Column {
        Button(onClick = {
            try {
                coroutine.launch {
                    try {
                        message = remoteReviewService.addReview(
                            params = HashMap<String, RequestBody>().apply {
                                put(
                                    "contents",
                                    "aaaa".toRequestBody("text/plain".toMediaTypeOrNull())
                                )
                                put(
                                    "torang_id",
                                    "1".toRequestBody("text/plain".toMediaTypeOrNull())
                                )
                                put(
                                    "user_id",
                                    "1".toRequestBody("text/plain".toMediaTypeOrNull())
                                )
                                put(
                                    "rating",
                                    "3".toRequestBody("text/plain".toMediaTypeOrNull())
                                )
                            },
                            file = file
                        ).toString()
                    } catch (e: HttpException) {
                        message = e.toString()
                    }
                }
            } catch (e: Exception) {
                message = e.toString()
            }
        }) {

        }
        Text(text = message)
    }

}