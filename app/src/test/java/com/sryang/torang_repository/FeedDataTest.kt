package com.sryang.torang_repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sryang.torang_core.data.entity.Restaurant
import com.sryang.torang_core.data.entity.User
import com.sryang.torang_repository.data.remote.RemoteFeed
import com.sryang.torang_repository.data.remote.response.FeedResponse
import org.junit.Assert
import org.junit.Test

class FeedDataTest {
    @Test
    fun test() {
        System.out.println("FeedDataTest")

        val list = ArrayList<FeedResponse>().apply {
//            add(
                /*FeedResponse(
                    review_id = 1,
                    user = User(
                        userId = 0,
                        userName = "userName",
                        email = "email",
                        loginPlatform = "",
                        createDate = "",
                        accessToken = "",
                        profilePicUrl = "",
                        point = 0,
                        reviewCount = 0,
                        following = 0,
                        followers = 0,
                        isFollow = false
                    ),
                    restaurant = Restaurant(

                    ),
                    contents = "abc"
                )*/
//            )
        }



        println(GsonBuilder().setPrettyPrinting().create().toJson(list))
        //println(feedResponse)
        Assert.assertEquals(4, 4)
    }
}