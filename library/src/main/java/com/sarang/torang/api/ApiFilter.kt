package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CityApiModel
import retrofit2.http.GET


interface ApiFilter {
    @GET("getCities")
    suspend fun getCities(): List<CityApiModel>
    @GET("getNations")
    suspend fun getNations(): List<CityApiModel>
}