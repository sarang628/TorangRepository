package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.data.Filter
import com.sarang.torang.repository.FindRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * runTest를 사용하면 코루틴 안에서 코드를 작성할 수 있다.
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class FindRepositoryTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var findRepository: FindRepository
    @Before fun setUp() { hiltRule.inject() }

    @Test
    fun loadFeedWithPageTest() = runTest {
        findRepository.search(Filter())
    }

    fun loadRestaurants() = runTest{
        assertEquals(true, findRepository.restaurants.first().isEmpty())

        findRepository.search(Filter())

        assertEquals(true, findRepository.restaurants.first().isNotEmpty())
    }

    @Test
    fun foodFilterTest() = runTest{
        loadRestaurants()

        val restaurantCount = findRepository.restaurants.first().size

        val koreanRestaurantCount = findRepository.restaurants.first().filter { it.restaurant.restaurantType == "KOREAN" }.size

        if(koreanRestaurantCount < restaurantCount){
            findRepository.setFoodType("KOREAN")

            println("기존 음식점 개수: ${restaurantCount}, 한국 음식점 개수: ${findRepository.restaurants.first().size}")

            assertEquals(true, restaurantCount != findRepository.restaurants.first().size)
        }else{
            throw Exception("검색한 음식점이 모두 한국 음식점이라 필터 테스트 불가.")
        }
    }

    @Test
    fun priceFilterTest() = runTest{
        loadRestaurants()

        val restaurantCount = findRepository.restaurants.first().size

        val priceRestaurantCount = findRepository.restaurants.first().filter { it.restaurant.prices == "$" }.size

        if(priceRestaurantCount < restaurantCount){
            findRepository.setPrice("$")

            println("기존 음식점 개수: ${restaurantCount}, $ 음식점 개수: ${findRepository.restaurants.first().size}")

            assertEquals(true, restaurantCount != findRepository.restaurants.first().size)
        }else{
            throw Exception("검색한 음식점이 모두 $ 음식점이라 필터 테스트 불가.")
        }
    }

    @Test
    fun ratingFilterTest() = runTest{
        loadRestaurants()

        val restaurantCount = findRepository.restaurants.first().size

        val ratingRestaurantCount = findRepository.restaurants.first().filter { it.restaurant.rating == 1f }.size

        if(ratingRestaurantCount < restaurantCount){
            findRepository.setRating("1")
            findRepository.setRating("2")
            findRepository.setRating("3")

            println("기존 음식점 개수: ${restaurantCount}, 1 음식점 개수: ${findRepository.restaurants.first().size}")

            assertEquals(true, restaurantCount != findRepository.restaurants.first().size)
        }else{
            throw Exception("검색한 음식점이 모두 1 음식점이라 필터 테스트 불가.")
        }
    }
}