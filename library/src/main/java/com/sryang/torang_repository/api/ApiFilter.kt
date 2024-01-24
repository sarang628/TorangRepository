package com.sryang.torang_repository.api

import com.sryang.torang_repository.data.remote.response.RemoteCity
import retrofit2.http.GET


interface ApiFilter {
    @GET("getCities")
    suspend fun getCities(): List<RemoteCity>

}