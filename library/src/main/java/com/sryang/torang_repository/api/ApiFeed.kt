package com.sryang.torang_repository.api

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
import com.sryang.torang_repository.data.RemoteFavorite
import com.sryang.torang_repository.data.RemoteLike
import com.sryang.torang_repository.data.RemoteReview
import com.sryang.torang_repository.data.remote.request.ReviewDeleteRequestVO
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException

/**
 * See
 * [피드](http://sarang628.iptime.org:8081/swagger-ui/#/%ED%94%BC%EB%93%9C)<br>
 * [좋아요](http://sarang628.iptime.org:8081/swagger-ui/#/%EC%A2%8B%EC%95%84%EC%9A%94)
 */
interface ApiFeed {
    @POST("getFeeds")
    suspend fun getFeeds(@Header("authorization") auth: String?): List<RemoteFeed>

    @POST("deleteReview")
    suspend fun deleteReview(@Body review: ReviewDeleteRequestVO): RemoteReview

    @FormUrlEncoded
    @POST("addLike")
    suspend fun addLike(
        @Header("authorization") auth: String,
        @Field("reviewId") reviewId: Int
    ): RemoteLike

    @FormUrlEncoded
    @POST("deleteLike")
    suspend fun deleteLike(@Field("likeId") likeId: Int): RemoteLike

    @FormUrlEncoded
    @POST("deleteFavorite")
    suspend fun deleteFavorite(@Field("favoriteId") likeId: Int): RemoteFavorite

    @FormUrlEncoded
    @POST("addFavorite")
    suspend fun addFavorite(
        @Header("authorization") auth: String,
        @Field("reviewId") reviewId: Int
    ): RemoteFavorite
}

@Composable
fun ApiFeedLikeTest(apiFeed: ApiFeed) {
    val scope = rememberCoroutineScope()

    var error: String by remember { mutableStateOf("") }
    var padding: String by remember { mutableStateOf("") }
    var loading: Boolean by remember { mutableStateOf(false) }

    Column {
        Text(text = "LikeTest")
        Button(onClick = {
            if (loading)
                return@Button
            loading = true
            scope.launch {
                try {
                    val result = apiFeed.addLike("", 64)
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
                Text(text = "좋아요 추가")
            }
        }
        Button(onClick = {
            scope.launch {
                try {
                    val result = apiFeed.deleteLike(14)
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
                Text(text = "좋아요 삭제")
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

@Composable
fun ApiFeedTest(remoteFeedServices: ApiFeed) {
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
                    val result = remoteFeedServices.getFeeds("")
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