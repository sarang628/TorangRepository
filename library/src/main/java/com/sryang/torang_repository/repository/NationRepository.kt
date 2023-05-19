package com.sryang.torang_repository.repository


import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.NationItem
import kotlinx.coroutines.flow.StateFlow

interface NationRepository : MapSharedRepository {
    suspend fun getNationItems(): List<NationItem>
    suspend fun findRestaurant(): List<Restaurant>
    fun getSelectNationItem(): StateFlow<NationItem>
    suspend fun selectNationItem(nationItem: NationItem)
}