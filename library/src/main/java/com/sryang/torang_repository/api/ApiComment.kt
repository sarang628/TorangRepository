package com.sryang.torang_repository.api

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.sryang.torang_repository.data.Comment
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * http://sarang628.iptime.org:8081/swagger-ui/#/%EC%BD%94%EB%A9%98%ED%8A%B8
 */
interface ApiComment {

    @FormUrlEncoded
    @POST("addComment")
    suspend fun addComment(
        @Field("review_id") review_id: Int,
        @Field("user_id") user_id: Int,
        @Field("comment") comment: String
    ): Comment

    @POST("modifyComment")
    suspend fun modifyComment(@Body comment: Comment): Comment

    @FormUrlEncoded
    @POST("deleteComment")
    suspend fun deleteComment(@Field("commentId") commentId: Int): Boolean

    @FormUrlEncoded
    @POST("getComments")
    suspend fun getComments(@Field("review_id") review_id: Int): List<Comment>
}

@Composable
fun ApiCommentTest(apiComment: ApiComment) {
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                apiComment.addComment(
                    review_id = 82,
                    user_id = 1,
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
            coroutine.launch {
                apiComment.getComments(82)
            }
        }) {
            Text(text = "get")
        }
    }

}