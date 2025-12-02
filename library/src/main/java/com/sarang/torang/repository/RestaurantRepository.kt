package com.sarang.torang.repository

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.GsonBuilder
import com.sarang.torang.data.HoursOfOperation
import com.sarang.torang.data.Menu
import com.sarang.torang.data.RestaurantDetail
import com.sarang.torang.data.remote.response.MenuApiModel
import com.sarang.torang.data.remote.response.RestaurantResponseDto
import kotlinx.coroutines.launch

interface RestaurantRepository {
    suspend fun loadRestaurant(restaurantId: Int): RestaurantResponseDto
    suspend fun loadMenus(restaurantId: Int): List<Menu>
    suspend fun loadHours(restaurantId: Int): List<HoursOfOperation>
    suspend fun loadRestaurantDetail(restaurantId: Int): RestaurantDetail
}