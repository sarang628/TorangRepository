package com.sryang.torang_repository.repository

import kotlinx.coroutines.flow.StateFlow

interface LoginCheckableRepository {
    val isLogin: StateFlow<Boolean>
}