package com.sryang.torang_repository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_core.data.entity.Review
import com.sryang.torang_repository.data.entity.ReviewDeleteRequestVO
import com.sryang.torang_repository.repository.FeedRepository
import com.sryang.torang_repository.services.FeedServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class FeedDeleteActivity : AppCompatActivity() {

    @Inject
    lateinit var feedRepository: FeedRepository

    @Inject
    lateinit var feedService: FeedServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_delete)

        lifecycleScope.launch {
            var list = feedRepository.loadFeed()
            Log.d("__sryang", list.toString())
            findViewById<RecyclerView>(R.id.rv_feed_delete).adapter =
                object : RecyclerView.Adapter<ViewHolder>() {
                    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                        return object : ViewHolder(TextView(parent.context)) {

                        }
                    }

                    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                        (holder.itemView as TextView).text =
                            list[position].review.reviewId.toString()

                        holder.itemView.setOnClickListener() {
                            deleteFeed(list[position].review.reviewId)
                        }
                    }

                    override fun getItemCount(): Int {
                        return list.size
                    }
                }
        }
    }

    fun deleteFeed(reviewId: Int) {
        AlertDialog.Builder(this@FeedDeleteActivity)
            .setMessage("${reviewId} 피드를 삭제하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                run {
                    lifecycleScope.launch {
                        feedService.deleteReview(ReviewDeleteRequestVO(reviewId = reviewId))
                    }
                }
            }
            /*.setNegativeButton("아니오") { _, _ ->
                {
                    Log.d("test", "test")
                }
            }*/
            .show()
    }
}