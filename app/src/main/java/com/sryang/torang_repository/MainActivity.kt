package com.sryang.torang_repository

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.MyReviewsRepository
import dagger.hilt.android.AndroidEntryPoint
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
        lifecycleScope.launchWhenResumed {
            userRepository.isLoginFlow().collect {
                Logger.d("" + it)
            }
        }
    }
}