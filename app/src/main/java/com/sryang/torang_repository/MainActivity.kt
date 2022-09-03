package com.sryang.torang_repository

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.MyReviewsRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: LoginRepository

    @Inject
    lateinit var myReviewsRepository: MyReviewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                userRepository.isLoginFlow().collect {
                    Logger.d("" + it)
                }
            }
        }

        runBlocking {
//            findViewById<TextView>(R.id.tv).text =
//                myReviewsRepository.getMyReviews3(4).toString()
        }
    }
}