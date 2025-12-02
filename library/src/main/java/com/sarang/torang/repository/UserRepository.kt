package com.sarang.torang.repository

import com.sarang.torang.data.remote.response.UserApiModel

interface UserRepository {
    suspend fun findById(userId: Int)    : UserApiModel
    suspend fun findByToken()            : UserApiModel
}
