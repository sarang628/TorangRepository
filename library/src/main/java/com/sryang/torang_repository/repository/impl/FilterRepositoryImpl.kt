package com.sryang.torang_repository.repository.impl


import com.sryang.torang_core.data.entity.*
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.repository.FilterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilterRepositoryImpl @Inject constructor() : FilterRepository {

    var filter: MutableStateFlow<Filter> = MutableStateFlow(Filter.createEmptyValue())

    override fun getCurrentFilter(): StateFlow<Filter> {
        return filter
    }

    override suspend fun selectRestaurantType(food: RestaurantType) {
        filter.update {
            val list = ArrayList<RestaurantType>()
            list.addAll(it.restaurantTypes)

            if (list.contains(food))
                list.remove(food)
            else
                list.add(food)

            Logger.d("filter copy")
            it.copy(restaurantTypes = list)
        }
    }

    override suspend fun selectPrice(price: Prices) {
        filter.update {
            if (it.prices == price)
                it.copy(prices = Prices.NONE)
            else
                it.copy(prices = price)
        }
    }

    override suspend fun selectRatings(ratings: Ratings) {
        filter.update {
            val list = ArrayList<Ratings>()
            list.addAll(it.ratings)
            if (list.contains(ratings))
                list.remove(ratings)
            else
                list.add(ratings)
            Logger.d("filter copy")
            it.copy(ratings = list)
        }
    }

    override suspend fun selectDistance(distances: Distances) {
        filter.update {
            if (it.distances == distances) {
                it.copy(
                    distances = Distances.NONE
                )
            } else {
                it.copy(
                    distances = distances
                )
            }
        }
    }

    override suspend fun getFilter(): Filter {
        return filter.value
    }
}