package com.sarang.torang.api

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentLike
import com.sarang.torang.data.remote.response.RemoteCity
import com.sarang.torang.session.SessionClientService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.w3c.dom.Comment
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiCommentLike {
    @POST("getAllCommentLike")
    suspend fun getAllCommentLike(@Header("authorization") auth: String): List<RemoteCommentLike>

    @FormUrlEncoded
    @POST("addCommentLike")
    suspend fun addCommentLike(
        @Header("authorization") auth: String,
        @Field("commentId") commentId: Int
    ): RemoteCommentLike

    @FormUrlEncoded
    @POST("deleteCommentLike")
    suspend fun deleteCommentLike(
        @Header("authorization") auth: String,
        @Field("commentId") commentId: Int
    ): Boolean

}

@Composable
fun ApiCommentLikeTest(
    apiCommentLike: ApiCommentLike,
    sessionClientService: SessionClientService? = null
) {
    var result by remember { mutableStateOf("") }
    var comments: List<RemoteCommentLike> by remember { mutableStateOf(ArrayList()) }
    val coroutine = rememberCoroutineScope()
    val height = LocalConfiguration.current.screenHeightDp
    val auth = sessionClientService?.getToken() ?: ""
    var commentId by remember { mutableStateOf("0") }
    Column {
        Text(text = "ApiCommentLikeTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(20.dp))
        Row(modifier = Modifier.height(height.dp)) {
            Column(Modifier.weight(0.3f)) {
                Button(onClick = {
                    coroutine.launch {
                        try {
                            comments =
                                apiCommentLike.getAllCommentLike(auth = auth)
                        } catch (e: Exception) {
                            result = e.toString()
                        }

                    }
                }) {
                    Text(text = "getAllCommentLike")
                }
                Button(onClick = {
                    coroutine.launch {
                        try {
                            result =
                                apiCommentLike.addCommentLike(auth, commentId = commentId.toInt())
                                    .toString()
                            comments = apiCommentLike.getAllCommentLike(auth)
                        } catch (e: Exception) {
                            result = e.toString()
                        }

                    }
                }) {
                    Column {
                        Text(text = "addCommentLike")
                        TextField(value = commentId, onValueChange = {
                            commentId = it
                        })
                    }

                }
                Button(onClick = {
                    coroutine.launch {
                        try {
                            result =
                                apiCommentLike.deleteCommentLike(
                                    auth,
                                    commentId.toInt()
                                )
                                    .toString()
                            comments = apiCommentLike.getAllCommentLike(auth)
                        } catch (e: Exception) {
                            result = e.toString()
                        }

                    }
                }) {
                    Column {
                        Text(text = "deleteCommentLike")
                        TextField(value = commentId, onValueChange = {
                            commentId = it
                        })
                    }
                }
                Text(text = "result ${result}")
            }
            Column(
                Modifier
                    .weight(0.7f)
            ) {
                LazyColumn(content = {
                    items(comments.size) {
                        Card(Modifier.padding(10.dp)) {
                            Column {
                                Text(text = comments[it].toString())
                                Button(onClick = {
                                    coroutine.launch {
                                        try {
                                            apiCommentLike.deleteCommentLike(
                                                auth = auth,
                                                commentId = comments[it].commentId
                                            )
                                            comments = apiCommentLike.getAllCommentLike(auth)
                                        } catch (e: Exception) {


                                        }
                                    }
                                }) {
                                    Text(text = "Delete")
                                }
                            }
                        }
                    }
                })
            }
        }
    }

}