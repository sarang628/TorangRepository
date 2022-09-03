package com.sryang.torang_repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sryang.torang_repository.data.remote.RemoteFeed
import com.sryang.torang_repository.data.remote.response.FeedResponse
import org.junit.Assert
import org.junit.Test

class FeedDataTest {
    @Test
    fun test() {
        System.out.println("FeedDataTest")

        val list = ArrayList<FeedResponse>().apply {
            add(
                FeedResponse(
                    review_id = 1,
                    contents = "abc"
                )
            )
        }



        println(GsonBuilder().setPrettyPrinting().create().toJson(list))
        //println(feedResponse)
        Assert.assertEquals(4, 2 + 3)
    }
}