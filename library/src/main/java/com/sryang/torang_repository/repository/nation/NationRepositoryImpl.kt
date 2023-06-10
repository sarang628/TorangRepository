package com.sryang.torang_repository.repository.nation

import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.NationItem
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.repository.map.MapSharedRepositoryImpl
import com.sryang.torang_repository.services.RestaurantService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NationRepositoryImpl @Inject constructor(
    private val restaurantDao: RestaurantDao,
    private val restaurantService: RestaurantService
) : NationRepository, MapSharedRepositoryImpl(restaurantDao, restaurantService) {

    private val selectNationItem: MutableStateFlow<NationItem> = MutableStateFlow(NationItem(0))

    override suspend fun getNationItems(): List<NationItem> {
        TODO("Not yet implemented")
    }

    override suspend fun findRestaurant(): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun getSelectNationItem(): Flow<NationItem> {
        return selectNationItem
    }

    override suspend fun selectNationItem(nationItem: NationItem) {
        selectNationItem.emit(nationItem)
    }

}

