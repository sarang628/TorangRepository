package com.sarang.torang.repository

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun logout()
    fun getUsername(): Flow<String?>
}

@Composable
fun SettingRepositoryTest(settingsRepository: SettingsRepository) {
    val name by settingsRepository.getUsername().collectAsState(initial = "")
    Column {
        name?.let {
            Text(text = it)
        }
    }
}