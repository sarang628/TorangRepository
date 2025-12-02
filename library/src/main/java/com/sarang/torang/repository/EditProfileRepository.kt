package com.sarang.torang.repository

import com.sarang.torang.data.EditProfileResponse


interface EditProfileRepository {
    suspend fun editProfile(name: String?, uri: String?): EditProfileResponse
}