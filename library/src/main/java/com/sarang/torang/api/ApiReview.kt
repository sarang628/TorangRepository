package com.sarang.torang.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.GsonBuilder
import com.sarang.torang.data.MenuReview
import com.sarang.torang.data.remote.response.FeedApiModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface ApiReview {
    @FormUrlEncoded
    @POST("getReviews")
    suspend fun getReviews(@Field("restaurant_id") id: Int): List<FeedApiModel>

    @FormUrlEncoded
    @POST("getMyReview")
    suspend fun getMyReview(@FieldMap params: Map<String, String>): FeedApiModel

    @Multipart
    @POST("addReview")
    suspend fun addReview(
        @Part("review_id") review_id: Int? = null,
        @Part("contents") contents: RequestBody,
        @Part("rating") rating: Float,
        @Part("torang_id") torang_id: Int?,
        @Part("user_id") user_id: Int,
        @Part("uploadedImage") uploadedImage: List<Int>? = null,
        @Part file: ArrayList<MultipartBody.Part>? = null
    ): FeedApiModel

    @POST("updateReview")
    suspend fun updateReview(@Body reviewBody: FeedApiModel): Call<FeedApiModel>

    @POST("deleteReview")
    suspend fun deleteReview(@Body review: FeedApiModel): FeedApiModel

    @Multipart
    @POST("updateReview")
    suspend fun updateReview(
        @PartMap params: HashMap<String, RequestBody>,
        @Part pictures: ArrayList<MultipartBody.Part>
    ): FeedApiModel

    @FormUrlEncoded
    @POST("getMyReviews")
    suspend fun getMyReviews(@FieldMap params: Map<String, String>): ArrayList<FeedApiModel>

    @POST("addMenuReview")
    suspend fun addMenuReview(@Body menuReview: MenuReview): Call<MenuReview>

    @POST("getMyMenuReviews")
    suspend fun getMyMenuReviews(@Body review: FeedApiModel): Call<ArrayList<MenuReview>>

    @FormUrlEncoded
    @POST("getMyReviewsByUserId")
    suspend fun getMyReviewsByUserId(@Field("userId") userId: Int): List<FeedApiModel>

    @FormUrlEncoded
    @POST("getReviewsById")
    suspend fun getReviewsById(@Field("reviewId") reviewId: Int): FeedApiModel


}

@Composable
fun ApiReviewTest(apiReview: ApiReview) {
    val coroutine = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }

    /*val file1 = Uri.fromFile(
        File("/storage/emulated/0/DCIM/06 interior/IMG_2082.JPG")
    ).toFile()*/

    ///storage/emulated/0/DCIM/06 interior/IMG_2082.JPG
    val file = ArrayList<MultipartBody.Part>().apply {
        /*add(
            MultipartBody.Part.createFormData(
                name = "file", filename = file1.name, body = file1.asRequestBody()
            )
        )*/
    }
    Column(
        Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        HorizontalDivider(color = Color.LightGray)
        Text(text = "ApiReviewTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Button(onClick = {
            coroutine.launch {
                try {
                    val result = apiReview.addReview(
                        review_id = 118,
                        contents = "contents1".toRequestBody(),
                        rating = 3.0f,
                        torang_id = 1,
                        user_id = 1,
                        file = file,
                        uploadedImage = arrayOf(252).toList()
                    )
                    message = GsonBuilder().setPrettyPrinting().create().toJson(result)
                } catch (e: Exception) {
                    message = e.handle()
                }
            }
        }) {
            Text(text = "Review Regist Test")
        }

        Button(onClick = {
            coroutine.launch {
                try {
                    message = apiReview.getReviews(1).toString()
                } catch (e: Exception) {
                    message = e.handle()
                }
            }
        }) {
            Text(text = "음식점 리뷰 가져오기 테스트")
        }
        Button(onClick = {
            coroutine.launch {
                try {
                    message = GsonBuilder().setPrettyPrinting().create()
                        .toJson(apiReview.getReviewsById(78))

                } catch (e: Exception) {
                    message = e.handle()
                }
            }
        }) {
            Text(text = "리뷰id로 리뷰 가져오기")
        }
        Button(onClick = {
            coroutine.launch {
                try {
                    message = GsonBuilder().setPrettyPrinting().create()
                        .toJson(apiReview.getMyReviewsByUserId(5))
                } catch (e: Exception) {
                    message = e.handle()
                }
            }
        }) {
            Text(text = "userid로 리뷰 가져오기")
        }
        Column(Modifier.weight(1f)) {}
        Text(modifier = Modifier.verticalScroll(rememberScrollState()), text = message)
        HorizontalDivider(color = Color.LightGray)
    }

}