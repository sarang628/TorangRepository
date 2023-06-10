package com.sryang.torang_repository.repository.login

import kotlinx.coroutines.flow.Flow

interface LoginCheckableRepository {
    val isLogin: Flow<Boolean>
}