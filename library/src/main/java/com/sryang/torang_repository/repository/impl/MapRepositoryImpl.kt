package com.sryang.torang_repository.repository.impl

import android.content.Context
import android.location.Location
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.repository.MapRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MapRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context,
    private val restaurantService: ApiRestaurant,
    private val restaurantDao: RestaurantDao
) : MapRepository {

    private val mapClick = MutableStateFlow<Boolean>(false)
//    private val location = MutableStateFlow(Location(0.0, 0.0))

    override fun getRestaurant(): Flow<List<RestaurantEntity>> {
        return restaurantDao.getRestaurant()
    }

    override suspend fun loadRestaurant() {
        val list = restaurantService.getAllRestaurant(HashMap())
        val data = ArrayList<RestaurantEntity>()
        for (restaurant in list) {
//            data.add(RestaurantEntity.parse(restaurant))
        }
        restaurantDao.insertAllRestaurant(data)
    }

    override fun getClickMap(): Flow<Boolean> {
        return mapClick
    }

    override suspend fun clickMap() {
        mapClick.emit(!mapClick.value)
    }

    var _northEastLatitude = 0.0
    override fun setNorthEastLatitude(latitude: Double) {
        _northEastLatitude = latitude
    }

    var _notthEastLongitude = 0.0
    override fun setNorthEastLongitude(longitude: Double) {
        _notthEastLongitude = longitude
    }

    var _southWestLatitude = 0.0
    override fun setSouthWestLatitude(latitude: Double) {
        _southWestLatitude = latitude
    }

    var _southWestLongitude = 0.0
    override fun setSouthWestLongitude(longitude: Double) {
        _southWestLongitude = longitude
    }

    override fun getNorthEastLatitude(): Double {
        return _northEastLatitude
    }

    override fun getNorthEastLongitude(): Double {
        return _notthEastLongitude
    }

    override fun getSouthWestLatitude(): Double {
        return _southWestLatitude
    }

    override fun getSouthWestLongitude(): Double {
        return _southWestLongitude
    }

    override suspend fun showCard() {
        if (mapClick.value)
            mapClick.emit(false)
    }

    override suspend fun setCurrentLocation(location: Location) {
        TODO("Not yet implemented")
    }

    override fun getCurrentLocationFlow(): Flow<Location> {
        TODO("Not yet implemented")
    }
}