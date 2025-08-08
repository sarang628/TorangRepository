package com.sarang.torang.repository

import android.view.Menu
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
import com.sarang.torang.data.RestaurantDetail
import com.sarang.torang.data.remote.response.RestaurantResponseDto
import kotlinx.coroutines.launch

interface RestaurantRepository {
    suspend fun loadRestaurant(restaurantId: Int): RestaurantResponseDto
    suspend fun loadMenus(restaurantId: Int): List<Menu>
    suspend fun loadHours(restaurantId: Int): List<HoursOfOperation>
    suspend fun loadRestaurantDetail(restaurantId: Int): RestaurantDetail
}

@Composable
fun RestaurantRepositoryTest(restaurantRepository: RestaurantRepository) {
    var result by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    RestaurantRepositoryTest(onLoadRestaurant = {
        coroutine.launch {
            try {
                result = GsonBuilder().setPrettyPrinting().create()
                    .toJson(restaurantRepository.loadRestaurant(it.toInt()))
            } catch (e: Exception) {
                result = e.toString()
            }
        }
    }, result = result,
        onLoadMenus = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(restaurantRepository.loadMenus(it.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        },
        onLoadHours = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(restaurantRepository.loadHours(it.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        },
        onLoadRestaurantDetail = {
            coroutine.launch {
                try {
                    result = GsonBuilder().setPrettyPrinting().create()
                        .toJson(restaurantRepository.loadRestaurantDetail(it.toInt()))
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun RestaurantRepositoryTest(
    onLoadRestaurant: (String) -> Unit,
    onLoadMenus: (String) -> Unit,
    onLoadHours: (String) -> Unit,
    onLoadRestaurantDetail: (String) -> Unit,
    result: String,
) {
    var restuarntId by remember { mutableStateOf("1") }

    Column {
        InputChip(selected = true, onClick = { onLoadRestaurant.invoke(restuarntId) }, label = {
            Text(text = "loadRestaurant:")
            BasicTextField(value = restuarntId, onValueChange = { restuarntId = it })
        })
        InputChip(selected = true, onClick = { onLoadMenus.invoke(restuarntId) }, label = {
            Text(text = "loadMenus:")
            BasicTextField(value = restuarntId, onValueChange = { restuarntId = it })
        })
        InputChip(selected = true, onClick = { onLoadHours.invoke(restuarntId) }, label = {
            Text(text = "loadHours:")
            BasicTextField(value = restuarntId, onValueChange = { restuarntId = it })
        })
        InputChip(selected = true, onClick = { onLoadRestaurantDetail.invoke(restuarntId) }, label = {
            Text(text = "loadRestaurantDetail:")
            BasicTextField(value = restuarntId, onValueChange = { restuarntId = it })
        })
        Text(text = result)
    }
}

@Preview
@Composable
fun PreviewRestaurantRepositoryTest() {
    RestaurantRepositoryTest(
        onLoadRestaurant = {},
        onLoadRestaurantDetail = {},
        onLoadHours = {},
        onLoadMenus = {},
        result = ""
    )
}