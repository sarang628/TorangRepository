package com.sryang.torang_repository.session

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.StateFlow

interface SessionClientService {
    fun getToken(): String?
}

@Composable
fun SessionClientServiceTest(sessionClientService: SessionClientService) {
    Text(text = sessionClientService.getToken() ?: "null")
}