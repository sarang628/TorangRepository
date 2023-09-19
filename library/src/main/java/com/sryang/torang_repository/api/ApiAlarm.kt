package com.sryang.torang_repository.api

import com.sryang.torang_repository.data.Alarm
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiAlarm {
    @FormUrlEncoded
    @POST("getAlarms")
    suspend fun getAlarms(@Field("user_id") user_id: Int): ArrayList<Alarm>
}