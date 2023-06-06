package com.sryang.torang_repository

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.test.FeedList
import com.sryang.torang_repository.test.FeedTest
import com.sryang.torang_repository.test.FeedTest1
import com.sryang.torang_repository.test.loadFeedByFile
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var feedDao: FeedDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FeedTest1(context = this@MainActivity, feedDao = feedDao)
        }
    }
}