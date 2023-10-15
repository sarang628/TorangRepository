package com.sryang.torang_repository.api

import android.graphics.Picture
import android.view.Menu
import com.sryang.torang_repository.data.Filter
import com.sryang.torang_repository.data.HoursOfOperation
import com.sryang.torang_repository.data.RestaurantDetail
import com.sryang.torang_repository.data.RemoteReview
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiRestaurant {
    @FormUrlEncoded
    @POST("getAllRestaurant")
    suspend fun getAllRestaurant(@FieldMap params: Map<String, String>): ArrayList<RemoteRestaurant>

    @POST("getFilterRestaurant")
    suspend fun getFilterRestaurant(@Body filter: Filter): ArrayList<RemoteRestaurant>

    @FormUrlEncoded
    @POST("getRestaurantById")
    suspend fun getRestaurantById(@Field("restaurant_id") restaurantId: Int): RemoteRestaurant

    @FormUrlEncoded
    @POST("getRestaurantDetail")
    suspend fun getRestaurantDetail(@Field("restaurant_id") restaurantId: Int): RestaurantDetail

    @FormUrlEncoded
    @POST("getOpenHours")
    suspend fun getHoursOfOperation(@FieldMap params: Map<String, String>): ArrayList<HoursOfOperation>

    @FormUrlEncoded
    @POST("getMenus")
    suspend fun getMenus(@FieldMap params: Map<String, String>): ArrayList<Menu>

    @FormUrlEncoded
    @POST("getPictures")
    suspend fun getPictures(@FieldMap params: Map<String, String>): ArrayList<Picture>

    @Multipart
    @POST("fileUpload")
    suspend fun fileUpload(
        @PartMap params: HashMap<String, RequestBody>,
        @Part pictures: ArrayList<MultipartBody.Part>
    ): RemoteReview

    @FormUrlEncoded
    @POST("deletePicture")
    suspend fun deletePicture(@FieldMap params: Map<String, String>): Call<Void>

    @FormUrlEncoded
    @POST("getTimelines")
    suspend fun getTimelines(@FieldMap params: Map<String, String>): Call<ArrayList<RemoteReview>>

    @FormUrlEncoded
    @POST("saveMenu")
    suspend fun saveMenu(@FieldMap params: Map<String, String>): Call<Void>
}