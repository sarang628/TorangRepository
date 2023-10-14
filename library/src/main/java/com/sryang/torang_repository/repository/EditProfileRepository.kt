package com.sryang.torang_repository.repository

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * 프로필 수정 응답
 */
enum class EditProfileResponse {
    SUCCESS,
    NO_USER
}

interface EditProfileRepository {
    suspend fun editProfile(userId: Int, name: String?, uri: String?): EditProfileResponse
    fun getUser(): Flow<LoggedInUserEntity?>
}

@Composable
fun EditProfileRepositoryTest(editProfileRepository: EditProfileRepository) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            editProfileRepository.editProfile(1, "", "")
        }
    }) {

    }
}