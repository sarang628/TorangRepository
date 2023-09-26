package com.sryang.torang_repository.repository.info

import android.content.Context
import android.view.Menu
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.data.HoursOfOperation
import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant
import com.sryang.torang_repository.repository.InfoRepository
import com.sryang.torang_repository.repository.MenuRepository
import com.sryang.torang_repository.repository.ReviewRepository
import com.sryang.torang_repository.repository.map.MapRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InfoRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context,
    private val restaurantService: ApiRestaurant,
    private val restaurantDao: RestaurantDao
) :
    InfoRepository {

    private val mapClick = MutableStateFlow<Boolean>(false)
//    private val location = MutableStateFlow(Location(0.0, 0.0))

    override suspend fun loadRestaurant(restaurantId: Int): RemoteRestaurant {
        return restaurantService.getRestaurant(HashMap<String, String>().apply {
            put("restaurant_id", restaurantId.toString())
        })
    }

    override suspend fun loadMenus(restaurantId: Int): ArrayList<Menu> {
        return restaurantService.getMenus(HashMap<String, String>().apply {
            put("restaurant_id", restaurantId.toString())
        })
    }

    override suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation> {
        return restaurantService.getHoursOfOperation(HashMap<String, String>().apply {
            put("restaurant_id", restaurantId.toString())
        })
    }
}