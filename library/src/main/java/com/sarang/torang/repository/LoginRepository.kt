package com.sarang.torang.repository

import com.sarang.torang.data.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    val         isLogin                                         : Flow<Boolean>
    val         loginUser                                       : Flow<User?>
    fun         getUserName()                                   : Flow<String>
    suspend fun emailLogin(email: String, password: String)
    suspend fun logout()
    suspend fun sessionCheck()                                  : Boolean
    suspend fun checkEmail(email: String, password: String)     : String
    suspend fun confirmCode(
        token: String,
        confirmCode: String,
        name: String,
        email: String,
        password: String,
    )                                                           : Boolean
}