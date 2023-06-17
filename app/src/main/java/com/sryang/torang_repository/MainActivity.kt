package com.sryang.torang_repository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sryang.torang_repository.services.FeedServices
import com.sryang.torang_repository.test.FeedServiceTest
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var feedServices: FeedServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            /*FeedRepositoryTest(
                context = this@MainActivity,
                feedDao = feedDao,
                pictureDao = pictureDao
            )*/


            FeedServiceTest(feedServices)
        }
    }
}