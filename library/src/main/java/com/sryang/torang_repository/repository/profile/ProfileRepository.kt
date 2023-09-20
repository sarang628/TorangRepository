package com.sryang.torang_repository.repository.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sryang.library.entity.user.UserProfile
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.UserEntity
import com.sryang.torang_repository.repository.feed.FeedListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

interface ProfileRepository : FeedListRepository {
    fun getMyProfile(): Flow<LoggedInUserEntity?>
    suspend fun loadProfile(userId: Int): UserProfile
    fun getMyFeed(userId: Int): Flow<List<FeedEntity>>
    fun getMyFavorite(userId: Int): Flow<List<FeedEntity>>
    suspend fun logout()

    override val isLogin: Flow<Boolean>
        get() = MutableStateFlow(false)
}

@Composable
fun ProfileRepositoryTest(profileRepository: ProfileRepository) {
//    var profile by remember { mutableStateOf(UserEntity(userId = 0, userName = "!®")) }
    var profile by remember { mutableStateOf("b") }
    var isProgress by remember { mutableStateOf(false) }
    val coroutine = rememberCoroutineScope()

    Column {
        Box()
        {
            Column {
                Button(onClick = {
                    coroutine.launch {
                        isProgress = true
                        val result = profileRepository.loadProfile(0)
                        profile = result.toString()
                        isProgress = false
                    }
                }) {

                }
                Text(
                    text = profile.toString()
                )
            }
            if (isProgress)
                CircularProgressIndicator()
        }
    }
}
