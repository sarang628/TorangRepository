package com.sryang.torang_repository.repository

import kotlinx.coroutines.flow.Flow

interface LoginCheckableRepository {
    val isLogin: Flow<Boolean>
}