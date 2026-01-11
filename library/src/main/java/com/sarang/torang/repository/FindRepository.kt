package com.sarang.torang.repository

import com.sarang.torang.data.Filter
import com.sarang.torang.data.RestaurantWithFiveImages
import kotlinx.coroutines.flow.StateFlow

interface FindRepository {
    val restaurants: StateFlow<List<RestaurantWithFiveImages>>
    suspend fun search(filter: Filter = Filter())
    suspend fun findFilter()
    suspend fun findThisArea()
}