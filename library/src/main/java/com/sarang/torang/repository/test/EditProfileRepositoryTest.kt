package com.sarang.torang.repository.test

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.sarang.torang.repository.EditProfileRepository
import kotlinx.coroutines.launch


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