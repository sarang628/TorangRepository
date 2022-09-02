package com.sryang.torang_repository.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.entity.LoggedInUserEntity

/**
 * 프로필 수정 응답
 */
enum class EditProfileResponse {
    SUCCESS,
    NO_USER
}

interface EditProfileRepository {
    suspend fun editProfile(name: String?, profilePictureUrl: String?): EditProfileResponse
    fun getUser(): LiveData<LoggedInUserEntity?>
}