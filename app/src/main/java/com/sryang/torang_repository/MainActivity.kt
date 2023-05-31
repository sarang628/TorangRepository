package com.sryang.torang_repository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.rememberCoroutineScope
import com.posco.feedscreentestapp.R
import com.sryang.torang_repository.data.AppDatabase
import com.sryang.torang_repository.data.entity.UserEntity
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getInstance(this)
        db.LoggedInUserDao().getLoggedInUserEntity()
        runBlocking {
            db.userDao().insertAll(listOf(UserEntity(userId = 1)))
        }
        setContent {
            Text(text = "")
        }
    }
}