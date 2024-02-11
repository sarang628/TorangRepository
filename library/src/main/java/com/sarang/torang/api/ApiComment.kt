package com.sarang.torang.api

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.RemoteCommentList
import com.sarang.torang.data.ToComposable
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
        @Field("comment") comment: String,
        @Field("parentCommentId") parentCommentId: Int? = null,
        @Field("tagUserId") tagUserId: Int? = null,
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

    @FormUrlEncoded
    @POST("getCommentsWithOneReply")
    suspend fun getCommentsWithOneReply(
        @Header("authorization") auth: String,
        @Field("review_id") reviewId: Int
    ): RemoteCommentList

    @FormUrlEncoded
    @POST("getSubComments")
    suspend fun getSubComments(
        @Header("authorization") auth: String,
        @Field("parentCommentId") parentCommentId: Int
    ): List<RemoteComment>
}

@Composable
fun ApiCommentTest(apiComment: ApiComment, sessionService: SessionService?) {
    val coroutine = rememberCoroutineScope()
    Column {
        Text(text = "ApiCommentTest", fontSize = 21.sp, fontWeight = FontWeight.Bold)
        sessionService?.let {
            AddComment(apiComment, sessionService)
            DeleteComment(apiComment, sessionService)
            GetComment(apiComment, sessionService)
            GetCommentsWithOneReply(apiComment, sessionService)
            LoadMore(apiComment, sessionService)
        }
    }
}

@Composable
internal fun AddComment(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            try {
                apiComment.addComment(
                    review_id = 329,
                    auth = sessionService.getToken()!!,
                    comment = "ㅋㅋㅋㅋㅋㅋ",
                    parentCommentId = 145,
                    tagUserId = 1
                )
            } catch (e: Exception) {
                Log.e("ApiCommentTest", e.message.toString())
            }
        }
    }) {
        Text(text = "add")
    }
}

@Composable
internal fun DeleteComment(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            apiComment.deleteComment(1)
        }
    }) {
        Text(text = "delete")
    }
}

@Composable
internal fun GetComment(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
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

@Composable
internal fun GetCommentsWithOneReply(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    var list by remember { mutableStateOf(RemoteCommentList("", list = listOf())) }
    var error by remember { mutableStateOf("") }
    Button(onClick = {
        sessionService.getToken().let {
            if (it == null) {
                error = "로그인을 해주세요."
            } else {
                coroutine.launch {
                    list = apiComment.getCommentsWithOneReply(it, 329)
                    Log.d("ApiCommentTest", list.toString())
                }
            }
        }
    }) {
        Text(text = "GetCommentWithReply")
    }
    Column {
        for (item in list.list) {
            item.ToComposable()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Text(text = error)
}

@Composable
internal fun LoadMore(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    var list: List<RemoteComment> by remember { mutableStateOf(ArrayList()) }
    var error by remember { mutableStateOf("") }
    Button(onClick = {
        sessionService.getToken().let {
            if (it == null) {
                error = "로그인을 해주세요."
            } else {
                coroutine.launch {
                    list = apiComment.getSubComments(it, 249)
                    Log.d("ApiCommentTest", list.toString())
                }
            }
        }
    }) {
        Text(text = "LoadMore")
    }
    Column {
        for (item in list) {
            item.ToComposable()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Text(text = error)
}