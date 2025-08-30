package com.sarang.torang.repository

import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.remote.response.FilterApiModel
import kotlinx.coroutines.flow.StateFlow

interface FindRepository {
    val restaurants: StateFlow<List<Restaurant>>
    suspend fun search(filter: FilterApiModel = FilterApiModel())
    suspend fun findFilter()
    suspend fun findThisArea()
}