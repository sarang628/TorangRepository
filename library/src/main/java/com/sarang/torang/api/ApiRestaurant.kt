package com.sarang.torang.api

import android.view.Menu
import com.sarang.torang.Picture
import com.sarang.torang.data.Filter
import com.sarang.torang.data.HoursOfOperation
import com.sarang.torang.data.RestaurantDetail
import com.sarang.torang.data.remote.response.FeedApiModel
import com.sarang.torang.data.remote.response.RestaurantApiModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface ApiRestaurant {
    @FormUrlEncoded
    @POST("getAllRestaurant")
    suspend fun getAllRestaurant(): ArrayList<RestaurantApiModel>

    @POST("getFilterRestaurant")
    suspend fun getFilterRestaurant(@Body filter: Filter): ArrayList<RestaurantApiModel>

    @FormUrlEncoded
    @POST("getRestaurantById")
    suspend fun getRestaurantById(@Field("restaurant_id") restaurantId: Int): RestaurantApiModel

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
    ): FeedApiModel

    @FormUrlEncoded
    @POST("deletePicture")
    suspend fun deletePicture(@FieldMap params: Map<String, String>): Call<Void>

    @FormUrlEncoded
    @POST("saveMenu")
    suspend fun saveMenu(@FieldMap params: Map<String, String>): Call<Void>
}