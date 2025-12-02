package com.sarang.torang.repository.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sarang.torang.repository.MapRepository

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