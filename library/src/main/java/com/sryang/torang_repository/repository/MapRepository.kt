package com.sryang.torang_repository.repository

import android.location.Location
import com.sryang.torang_repository.data.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

interface MapRepository {
    @Deprecated("findRepository로 이동")
    fun getRestaurant(): Flow<List<RestaurantEntity>>

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
    fun getCurrentLocationFlow() : Flow<Location>
}