package com.sryang.torang_repository.repository

import androidx.lifecycle.LiveData

interface LoginCheckableRepository {
    val isLogin: LiveData<Boolean>
}