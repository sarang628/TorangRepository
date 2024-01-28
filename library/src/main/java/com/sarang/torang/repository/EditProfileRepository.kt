package com.sarang.torang.repository

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

/**
 * 프로필 수정 응답
 */
enum class EditProfileResponse {
    SUCCESS,
    NO_USER
}

interface EditProfileRepository {
    suspend fun editProfile(name: String?, uri: String?): EditProfileResponse
}

@Composable
fun EditProfileRepositoryTest(editProfileRepository: EditProfileRepository) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            editProfileRepository.editProfile("", "")
        }
    }) {

    }
}