package com.sryang.torang_repository.data


data class Filter(
    var searchType: SearchType = SearchType.AROUND,
    var keyword: String? = null,
    var distances: Distances = Distances.NONE,
    var prices: Prices = Prices.NONE,
    var restaurantTypes: List<RestaurantType>,
    var ratings: List<Ratings>,
    var lat: Double? = null,
    var lon: Double? = null,
    var north: Double = 0.0,
    var east: Double = 0.0,
    var south: Double = 0.0,
    var west: Double = 0.0
)