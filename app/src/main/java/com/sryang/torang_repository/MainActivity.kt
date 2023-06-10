package com.sryang.torang_repository

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.PictureDao
import com.sryang.torang_repository.di.ProductFeedServiceImpl
import com.sryang.torang_repository.services.FeedServices
import com.sryang.torang_repository.test.FeedRepositoryTest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var feedDao: FeedDao

    @Inject
    lateinit var pictureDao: PictureDao

    @Inject
    lateinit var feedServices: FeedServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        runBlocking {
            val result = feedServices.getFeeds(HashMap())
            Log.d("sryang123", result.toString())
        }

        setContent {
            FeedRepositoryTest(
                context = this@MainActivity,
                feedDao = feedDao,
                pictureDao = pictureDao
            )
        }
    }
}