package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData

interface LoginCheckableRepository {
    val isLogin: LiveData<Boolean>
}