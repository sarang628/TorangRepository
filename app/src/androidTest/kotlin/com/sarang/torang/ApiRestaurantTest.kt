package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiChat
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.repository.ChatRepository
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.session.SessionService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ApiRestaurantTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiRestaurant: ApiRestaurant

    @Inject
    lateinit var loginRepository: LoginRepository

    @Inject
    lateinit var sessionService: SessionService

    @Before
    fun setUp() = runTest {
        hiltRule.inject()

        //loginRepository.encEmailLogin("sry_ang@naver.com", "Torang!234")
    }

    @Test
    fun getAllRestaurantTest() = runTest {
        val result = apiRestaurant.getAllRestaurant()
        println(GsonBuilder().setPrettyPrinting().create().toJson(result))
        assert(!result.isEmpty())
    }

    @Test
    fun getRestaurantInfo() = runTest {
        val result = apiRestaurant.getRestaurantDetail(234)
        println(GsonBuilder().setPrettyPrinting().create().toJson(result))
        assert(result.restaurant.restaurantId == 234)
    }

}