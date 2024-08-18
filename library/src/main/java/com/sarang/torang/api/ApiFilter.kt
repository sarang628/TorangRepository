package com.sarang.torang.api

import com.sarang.torang.data.remote.response.CityApiModel
import com.sarang.torang.data.remote.response.NationApiModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFilter {
    @GET("getCities")
    suspend fun getCities(): List<CityApiModel>

    @GET("getCitiesByNationId")
    suspend fun getCitiesByNationId(@Query("nationId") nationId: Int): List<CityApiModel>

    @GET("getNations")
    suspend fun getNations(): List<NationApiModel>
}