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
import com.sarang.torang.data.remote.response.FavoriteApiModel
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.LikeApiModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
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
    suspend fun getFeeds(@Header("authorization") auth: String?): List<FeedApiModel>

    @FormUrlEncoded
    @POST("getFeedsWithPage")
    suspend fun getFeedsWithPage(
        @Header("authorization") auth: String?,
        @Field("page") page: Int
    ): List<FeedApiModel>

    @FormUrlEncoded
    @POST("loadUserAllFeedsByReviewId")
    suspend fun loadUserAllFeedsByReviewId(
        @Header("authorization") auth: String?,
        @Field("reviewId") reviewId: Int
    ): List<FeedApiModel>

    @FormUrlEncoded
    @POST("getFeedByReviewId")
    suspend fun getFeedByReviewId(
        @Header("authorization") auth: String?,
        @Field("reviewId") reviewId: Int
    ): FeedApiModel

    @FormUrlEncoded
    @POST("deleteReview")
    suspend fun deleteReview(@Field("reviewId") reviewId: Int)

    @FormUrlEncoded
    @POST("addLike")
    suspend fun addLike(
        @Header("authorization") auth: String,
        @Field("reviewId") reviewId: Int
    ): LikeApiModel

    @FormUrlEncoded
    @POST("deleteLike")
    suspend fun deleteLike(@Field("likeId") likeId: Int): LikeApiModel

    @FormUrlEncoded
    @POST("deleteFavorite")
    suspend fun deleteFavorite(@Field("favoriteId") likeId: Int): FavoriteApiModel

    @FormUrlEncoded
    @POST("addFavorite")
    suspend fun addFavorite(
        @Header("authorization") auth: String,
        @Field("reviewId") reviewId: Int
    ): FavoriteApiModel

    /**
     * 5. 리뷰ID로 다음 피드 가져오기
     */
    @FormUrlEncoded
    @POST("getNextReviewsByReviewId")
    suspend fun getNextReviewsByReviewId(
        @Header("authorization") auth: String?,
        @Field("reviewId") reviewId: Int,
        @Field("count") count: Int
    ): List<FeedApiModel>
}