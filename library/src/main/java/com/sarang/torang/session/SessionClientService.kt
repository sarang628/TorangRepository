package com.sarang.torang.session

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

interface SessionClientService {
    fun getToken(): String?
}

@Composable
fun SessionClientServiceTest(sessionClientService: SessionClientService) {
    Text(text = sessionClientService.getToken() ?: "null")
}