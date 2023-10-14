package com.sryang.torang_repository.repository


import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.NationItem
import kotlinx.coroutines.flow.Flow

interface NationRepository : MapSharedRepository {
    suspend fun getNationItems(): List<NationItem>
    suspend fun findRestaurant(): List<Restaurant>
    fun getSelectNationItem(): Flow<NationItem>
    suspend fun selectNationItem(nationItem: NationItem)
}