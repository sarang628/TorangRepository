package com.sryang.torang_repository.services

import android.graphics.Picture
import android.view.Menu
import com.sryang.torang_repository.Alarm
import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Comment
import com.sryang.torang_repository.data.Favorite
import com.sryang.torang_repository.data.Filter
import com.sryang.torang_repository.data.HoursOfOperation
import com.sryang.torang_repository.data.Like
import com.sryang.torang_repository.data.MenuReview
import com.sryang.torang_repository.data.Review
import com.sryang.torang_repository.data.User
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import com.sryang.torang_repository.data.remote.response.Response
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface LoginService {
    @FormUrlEncoded
    @POST("emailLogin")
    suspend fun emailLogin(
        //@FieldMap params: Map<String, String>
        @Field("email") email: String,
        @Field("password") password: String
    ): Boolean

    @POST("join")
    suspend fun join(@Body filter: Filter): ArrayList<Restaurant>
}