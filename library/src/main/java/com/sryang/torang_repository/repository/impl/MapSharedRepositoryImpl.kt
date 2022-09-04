package com.sryang.torang_repository.repository.impl

import com.sryang.torang_repository.services.RestaurantService
import com.sryang.torang_repository.util.DistanceManager.getDistance
import com.sryang.torang_core.data.entity.Filter
import com.sryang.torang_repository.repository.MapSharedRepository
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.data.entity.RestaurantEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class MapSharedRepositoryImpl @Inject constructor(
    private val restaurantDao: RestaurantDao,
    private val restaurantService: RestaurantService
) :
    MapSharedRepository {

    override suspend fun searchRestaurant(
        latitude: Double,
        longitude: Double
    ): List<RestaurantEntity> {
        Logger.d("$latitude, $longitude")
        val list = restaurantDao.getRestaurantDistance()
        return list.sortedWith { o1, o2 ->
            when {
                getDistance(latitude, longitude, o1.lat!!, o1.lon!!) <
                        getDistance(latitude, longitude, o2.lat!!, o2.lon!!) -> -1
                getDistance(latitude, longitude, o1.lat!!, o1.lon!!) ==
                        getDistance(latitude, longitude, o2.lat!!, o2.lon!!) -> 0
                else -> 1
            }
        }
    }

    override suspend fun searchRestaurant(keyword: String): List<RestaurantEntity> {
        TODO()
        /*val filter = Filter()
        filter.keyword = keyword
        val list = ArrayList<RestaurantEntity>()
        val restaurants = restaurantService.getFilterRestaurant(filter)
        for (restaurant in restaurants) {
            list.add(RestaurantEntity.parse(restaurant))
        }
        return list*/
    }

    override suspend fun getFilterRestaurant(filter: Filter): List<RestaurantEntity> {
        val list = ArrayList<RestaurantEntity>()
        val restaurants = restaurantService.getFilterRestaurant(filter)
        for (restaurant in restaurants) {
            list.add(RestaurantEntity.parse(restaurant))
        }
        restaurantDao.insertAllRestaurant(list)
        return list
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class MapShareRepositoryProvider {
    @Binds
    abstract fun provideMapShareRepository(mapSharedRepositoryImpl: MapSharedRepositoryImpl): MapSharedRepository
}