package com.sryang.torang_core.repository

import com.sryang.torang_core.data.NationItem
import com.sryang.torang_core.data.data.Restaurant
import kotlinx.coroutines.flow.StateFlow

interface NationRepository : MapSharedRepository {
    suspend fun getNationItems(): List<NationItem>
    suspend fun findRestaurant(): List<Restaurant>
    fun getSelectNationItem(): StateFlow<NationItem>
    suspend fun selectNationItem(nationItem: NationItem)
}