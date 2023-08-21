package com.sryang.torang_repository.services

import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Filter
import retrofit2.http.*

interface LoginService {
    @FormUrlEncoded
    @POST("emailLogin")
    suspend fun emailLogin(
        //@FieldMap params: Map<String, String>
        @Field("email") email: String,
        @Field("passWord") password: String
    ): Boolean

    @POST("join")
    suspend fun join(@Body filter: Filter): ArrayList<Restaurant>
}