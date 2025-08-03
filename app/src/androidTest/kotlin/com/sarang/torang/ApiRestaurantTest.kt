package com.sarang.torang

import androidx.test.runner.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.data.Filter
import com.sarang.torang.data.dao.SearchedRestaurantDao
import com.sarang.torang.data.entity.SearchedRestaurantEntity
import com.sarang.torang.data.entity.fromRestaurantApiModel
import com.sarang.torang.repository.LoginRepository
import com.sarang.torang.session.SessionService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ApiRestaurantTest {
    // @formatter:off
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var apiRestaurant: ApiRestaurant
    @Inject lateinit var loginRepository: LoginRepository
    @Inject lateinit var sessionService: SessionService
    @Inject lateinit var searchedRestaurantDao: SearchedRestaurantDao
    // @formatter:on

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

    @Test
    fun getFilterRestaurantTest() = runTest {
        val result = apiRestaurant.getFilterRestaurant(Filter())
        println(GsonBuilder().setPrettyPrinting().create().toJson(result))
    }

    @Test
    fun test() = runTest {
        val result = apiRestaurant.getFilterRestaurant(Filter())
        searchedRestaurantDao.insertAllRestaurant(SearchedRestaurantEntity.fromRestaurantApiModel(result));
        println(GsonBuilder().setPrettyPrinting().create().toJson(searchedRestaurantDao.getAll()))
        searchedRestaurantDao.deleteAll()
        println(GsonBuilder().setPrettyPrinting().create().toJson(searchedRestaurantDao.getAll()))
    }

}