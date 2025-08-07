package com.sarang.torang.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import com.sarang.torang.data.Filter
import com.sarang.torang.data.remote.response.RestaurantApiModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

interface FindRepository {
    val restaurants: StateFlow<List<RestaurantApiModel>>
    suspend fun search(filter: Filter = Filter())
}

@Composable
fun FindRepositoryTest(findRepository: FindRepository) {
    val coroutine = rememberCoroutineScope()
    val restaurants = findRepository.restaurants.collectAsState().value
    Column {
        Button({
            coroutine.launch { findRepository.search() }
        }) {}
        Text(restaurants.toString())
    }
}