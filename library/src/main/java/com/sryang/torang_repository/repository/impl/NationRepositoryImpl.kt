package com.example.torangrepository.repository.impl

import com.example.torang_core.data.NationItem
import com.example.torang_core.data.dao.RestaurantDao
import com.example.torang_core.data.model.Restaurant
import com.example.torang_core.repository.NationRepository
import com.sryang.torang_repository.repository.impl.MapSharedRepositoryImpl
import com.sryang.torang_repository.services.RestaurantService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NationRepositoryImpl @Inject constructor(
    private val restaurantDao: RestaurantDao,
    private val restaurantService: RestaurantService
) : NationRepository, MapSharedRepositoryImpl(restaurantDao, restaurantService) {

    private val selectNationItem: MutableStateFlow<NationItem> = MutableStateFlow(NationItem())

    override suspend fun getNationItems(): List<NationItem> {
        TODO("Not yet implemented")
    }

    override suspend fun findRestaurant(): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun getSelectNationItem(): StateFlow<NationItem> {
        return selectNationItem
    }

    override suspend fun selectNationItem(nationItem: NationItem) {
        selectNationItem.emit(nationItem)
    }

}

