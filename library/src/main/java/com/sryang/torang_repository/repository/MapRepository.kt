package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.RestaurantEntity
import com.sryang.torang_core.data.data.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MapRepository {
    @Deprecated("findRepository로 이동")
    fun getRestaurant(): LiveData<List<RestaurantEntity>>

    @Deprecated("findRepository로 이동")
    suspend fun loadRestaurant()

    /** 맵 클릭 시 정보 표시 여부 애니메이션 */
    @Deprecated("findRepository로 이동")
    fun getClickMap(): Flow<Boolean>
    suspend fun clickMap()

    /** 현재 보이는 지도 범위 좌표 저장 */
    fun setNorthEastLatitude(latitude: Double)
    fun setNorthEastLongitude(longitude: Double)
    fun setSouthWestLatitude(latitude: Double)
    fun setSouthWestLongitude(longitude: Double)

    fun getNorthEastLatitude(): Double
    fun getNorthEastLongitude(): Double
    fun getSouthWestLatitude(): Double
    fun getSouthWestLongitude(): Double

    suspend fun showCard()

    suspend fun setCurrentLocation(location : Location)
    fun getCurrentLocationFlow() : StateFlow<Location>
}