package com.sryang.torang_repository.session

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.StateFlow

interface SessionClientService {
    val isLogin: StateFlow<Boolean>
    fun getToken(): String?
}

@Composable
fun SessionClientServiceTest(sessionClientService: SessionClientService) {
    Text(text = sessionClientService.getToken() ?: "null")
}