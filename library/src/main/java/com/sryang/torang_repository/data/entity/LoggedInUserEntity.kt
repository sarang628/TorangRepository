package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoggedInUserEntity(
    @PrimaryKey val constId: Int,
    val userId: Int,
    val userName: String,
    val email: String,
    val loginPlatform: String,
    val createDate: String,
    val accessToken: String,
    val profilePicUrl: String,
    val point: Int,
    val reviewCount: String,
    val followers: String,
    val following: String
)