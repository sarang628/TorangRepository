package com.sarang.torang.repository

import com.sarang.torang.data.User

interface UserRepository {
    suspend fun findById(userId: Int)    : User
    suspend fun findByToken()            : User
}
