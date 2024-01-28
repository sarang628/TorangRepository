package com.sarang.torang.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

interface MapRepository {
    /** 미자막 좌표 저장 zoom level 저장 */
    fun saveLat(lat: Double)
    fun savelon(lon: Double)
    fun saveZoom(level: Float)
    fun loadLat(): Double
    fun loadLon(): Double
    fun loadZoom(): Float
    fun setNElat(latitude: Double)
    fun setNElon(longitude: Double)
    fun setSWlat(latitude: Double)
    fun setSWlon(latitude: Double)
    fun getNElat(): Double
    fun getNElon(): Double
    fun getSWlat(): Double
    fun getSWlon(): Double
}

@Composable
fun MapRepositoryTest(mapRepository: MapRepository) {
    Column {
        Button(onClick = { mapRepository.saveLat(10.0) }) {
            Text(text = "SaveLat")
        }
        Button(onClick = { mapRepository.savelon(10.0) }) {
            Text(text = "SaveLon")
        }
        Button(onClick = { mapRepository.saveZoom(10.0f) }) {
            Text(text = "saveZoom")
        }

        Text(text = "lat ${mapRepository.loadLat()}")
        Text(text = "lon ${mapRepository.loadLon()}")
        Text(text = "lon ${mapRepository.loadZoom()}")
    }
}