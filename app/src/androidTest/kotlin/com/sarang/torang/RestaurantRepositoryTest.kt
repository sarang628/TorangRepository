package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.repository.RestaurantRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class RestaurantRepositoryTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var restaurantRepository: RestaurantRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun loadRestaurantTest() = runTest {
        var result = restaurantRepository.loadRestaurant(234)

        assertTrue(result.restaurantName!!.isNotEmpty())
    }

    @Test
    fun loadRestaurantDetailTest() = runTest {
        var result = restaurantRepository.loadRestaurantDetail(234)

        assertTrue(result.restaurant.restaurantName!!.isNotEmpty())
    }

    @Test
    fun loadHoursTest() = runTest {
        var result = restaurantRepository.loadHours(234)

        assertTrue(result.isNotEmpty())
    }

    @Test
    fun loadMenuTest() = runTest {
        var result = restaurantRepository.loadMenus(234)

        assertTrue(result.isNotEmpty())
    }


}