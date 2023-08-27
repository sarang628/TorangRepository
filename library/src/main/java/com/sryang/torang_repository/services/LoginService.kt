package com.sryang.torang_repository.services

import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Filter
import retrofit2.http.*

interface LoginService {
    @FormUrlEncoded
    @POST("emailLogin")
    suspend fun emailLogin(
        @Field("email") email: String,
        @Field("passWord") password: String
    ): String

    @POST("join")
    suspend fun join(@Body filter: Filter): ArrayList<Restaurant>
}