package com.sarang.torang.repository

import kotlinx.coroutines.flow.Flow

interface LoginCheckableRepository {
    val isLogin: Flow<Boolean>
}