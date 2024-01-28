package com.sarang.torang.api

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import com.sarang.torang.session.SessionService
import kotlinx.coroutines.launch
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * http://sarang628.iptime.org:8081/swagger-ui/#/%EC%BD%94%EB%A9%98%ED%8A%B8
 */
interface ApiComment {

    @FormUrlEncoded
    @POST("addComment")
    suspend fun addComment(
        @Header("authorization") auth: String,
        @Field("review_id") review_id: Int,
        @Field("comment") comment: String
    ): RemoteComment

    @POST("modifyComment")
    suspend fun modifyComment(@Body comment: RemoteComment): RemoteComment

    @FormUrlEncoded
    @POST("deleteComment")
    suspend fun deleteComment(@Field("commentId") commentId: Int): Boolean

    @FormUrlEncoded
    @POST("getComments")
    suspend fun getComments(
        @Header("authorization") auth: String,
        @Field("review_id") reviewId: Int
    ): RemoteCommentList
}

@Composable
fun ApiCommentTest(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                apiComment.addComment(
                    review_id = 82,
                    auth = "",
                    comment = "ㅋㅋㅋㅋㅋㅋ"
                )
            }
        }) {
            Text(text = "add")
        }

        Button(onClick = {
            coroutine.launch {
                apiComment.deleteComment(1)
            }
        }) {
            Text(text = "delete")
        }

        Button(onClick = {
            sessionService.getToken()?.let {
                coroutine.launch {
                    val list = apiComment.getComments(it, 82)
                    Log.d("ApiCommentTest", list.toString())
                }
            }
        }) {
            Text(text = "get")
        }
    }

}