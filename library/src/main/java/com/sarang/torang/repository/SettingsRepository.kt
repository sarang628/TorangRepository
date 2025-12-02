package com.sarang.torang.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun logout()
    fun getUsername(): Flow<String?>
}