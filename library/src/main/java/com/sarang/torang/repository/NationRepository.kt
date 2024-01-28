package com.sarang.torang.repository


import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.NationItem
import kotlinx.coroutines.flow.Flow

interface NationRepository {
    suspend fun getNationItems(): List<NationItem>
    suspend fun findRestaurant(): List<Restaurant>
    fun getSelectNationItem(): Flow<NationItem>
    suspend fun selectNationItem(nationItem: NationItem)
}