package com.sryang.torang_repository

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.databinding.ActivityFeedRepositoryTestBinding
import com.sryang.torang_repository.repository.FeedRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.concurrent.Callable
import javax.inject.Inject

@AndroidEntryPoint
class FeedRepositoryTestActivity : AppCompatActivity() {

    @Inject
    lateinit var feedRepository: FeedRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFeedRepositoryTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener {
            binding.pb.visibility = View.VISIBLE
            lifecycleScope.launch {
                val response = feedRepository.loadFeed()
                binding.pb.visibility = View.INVISIBLE
                if (response.status != 200) {
                    binding.tvResult.text = "status = ${response.status}\n" +
                            "data =  ${response.data}"
                } else {
                    binding.tvResult.text = response.data.toString()
                }
            }
        }
    }
}