package com.sryang.torang_repository

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.gson.GsonBuilder
import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.databinding.ActivityFeedRepositoryTestBinding
import com.sryang.torang_repository.repository.FeedRepository
import com.sryang.torang_repository.services.FeedServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.concurrent.Callable
import javax.inject.Inject

@AndroidEntryPoint
class FeedRepositoryTestActivity : AppCompatActivity() {

    @Inject
    lateinit var feedRepository: FeedRepository

    @Inject
    lateinit var feedService: FeedServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFeedRepositoryTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvFeedService.text = feedService.javaClass.simpleName

        binding.btnLoad.setOnClickListener {
            binding.pb.visibility = View.VISIBLE
            lifecycleScope.launch {
                val response = feedRepository.loadFeed()
                binding.pb.visibility = View.INVISIBLE
                if (response.status != 200) {
                    binding.tvResult.text = "status = ${response.status}\n" +
                            "data =  ${response.data}\n" +
                            "error = ${response.errorMessage}"
                } else {
                    binding.tvResult.text =
                        GsonBuilder().setPrettyPrinting().create().toJson(response.data)
                }
            }
        }
    }
}