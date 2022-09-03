package com.sryang.torang_repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sryang.torang_repository.data.remote.RemoteFeed
import com.sryang.torang_repository.data.remote.response.FeedResponse
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FeedDataTest {
    @Test
    fun test() {
        System.out.println("FeedDataTest")

        val feedResponse = FeedResponse(
            review_id = 1,
            contents = "abc"
        )

        val gson = Gson().toJson(feedResponse)
        
        println("!!!!!!!!!")
        println(feedResponse)
        Assert.assertEquals(4, 2 + 3)
    }
}