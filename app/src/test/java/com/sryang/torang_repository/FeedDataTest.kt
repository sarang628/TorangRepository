package com.sryang.torang_repository

import com.sryang.torang_repository.data.remote.response.FeedResponse
import org.junit.Assert
import org.junit.Test

class FeedDataTest {
    @Test
    fun test() {
        System.out.println("FeedDataTest")

        val feedResponse = FeedResponse()
        println("!!!!!!!!!")
        println(feedResponse)
        Assert.assertEquals(4, 2 + 3)
    }
}