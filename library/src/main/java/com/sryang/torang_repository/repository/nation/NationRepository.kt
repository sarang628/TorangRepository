package com.sryang.torang_repository.repository.nation


import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.NationItem
import com.sryang.torang_repository.repository.map.MapSharedRepository
import kotlinx.coroutines.flow.Flow

interface NationRepository : MapSharedRepository {
    suspend fun getNationItems(): List<NationItem>
    suspend fun findRestaurant(): List<Restaurant>
    fun getSelectNationItem(): Flow<NationItem>
    suspend fun selectNationItem(nationItem: NationItem)
}