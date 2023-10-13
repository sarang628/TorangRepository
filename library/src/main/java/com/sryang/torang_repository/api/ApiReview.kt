package com.sryang.torang_repository.api

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
import com.google.gson.JsonObject
import com.sryang.torang_repository.data.MenuReview
import com.sryang.torang_repository.data.Review
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import java.io.File

interface ApiReview {
    @FormUrlEncoded
    @POST("getReviews")
    suspend fun getReviews(@FieldMap params: Map<String, String>): ArrayList<Review>

    @FormUrlEncoded
    @POST("getMyReview")
    suspend fun getMyReview(@FieldMap params: Map<String, String>): Call<Review>

    @Multipart
    @POST("addReview")
    suspend fun addReview(
        @PartMap params: HashMap<String, RequestBody>,
        @Part file: ArrayList<MultipartBody.Part>
    ): JsonObject

    @POST("updateReview")
    suspend fun updateReview(@Body reviewBody: Review): Call<Review>

    @POST("deleteReview")
    suspend fun deleteReview(@Body review: Review): Review

    @Multipart
    @POST("updateReview")
    suspend fun updateReview(
        @PartMap params: HashMap<String, RequestBody>,
        @Part pictures: ArrayList<MultipartBody.Part>
    ): Review

    @FormUrlEncoded
    @POST("getMyReviews")
    suspend fun getMyReviews(@FieldMap params: Map<String, String>): ArrayList<Review>

    @POST("addMenuReview")
    suspend fun addMenuReview(@Body menuReview: MenuReview): Call<MenuReview>

    @POST("getMyMenuReviews")
    suspend fun getMyMenuReviews(@Body review: Review): Call<ArrayList<MenuReview>>

    @FormUrlEncoded
    @POST("getMyReviewsByUserId")
    suspend fun getMyReviewsByUserId(@FieldMap params: Map<String, String>): Call<ArrayList<Review>>
}

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