package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.flow.StateFlow

/**
 * 프로필 수정 응답
 */
enum class EditProfileResponse {
    SUCCESS,
    NO_USER
}

interface EditProfileRepository {
    suspend fun editProfile(name: String?, profilePictureUrl: String?): EditProfileResponse
    fun getUser(): StateFlow<LoggedInUserEntity?>
}