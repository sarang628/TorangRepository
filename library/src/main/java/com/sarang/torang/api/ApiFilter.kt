package com.sarang.torang.api

import com.sarang.torang.data.remote.response.RemoteCity
import retrofit2.http.GET


interface ApiFilter {
    @GET("getCities")
    suspend fun getCities(): List<RemoteCity>

}