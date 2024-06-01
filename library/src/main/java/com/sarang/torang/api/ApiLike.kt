package com.sarang.torang.api

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.google.gson.GsonBuilder
import com.sarang.torang.data.remote.response.RemoteFollower
import com.sarang.torang.session.SessionService
import kotlinx.coroutines.launch
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiLike {
    @FormUrlEncoded
    @POST("getLikeUserByReviewId")
    suspend fun getLikeUserByReviewId(
        @Header("authorization") auth: String,
        @Field("reviewId") Int: String,
    ): List<RemoteFollower>

}

@Composable
fun ApiLikeTest(
    apiLike: ApiLike,
    sessionService: SessionService,
) {
    var result by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                val token = sessionService.getToken()
                if (token == null) {
                    result = "로그인을 해주세요."
                } else {
                    try {
                        result = GsonBuilder().setPrettyPrinting().create()
                            .toJson(apiLike.getLikeUserByReviewId(token, "399"))
                    } catch (e: Exception) {
                        result = e.message.toString()
                    }
                }

            }
        }) {

        }
        Text(text = result)
    }

}