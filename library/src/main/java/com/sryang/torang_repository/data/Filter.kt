package com.sryang.torang_repository.data


data class Filter(
    var searchType: SearchType = SearchType.AROUND,
    var keyword: String? = null,
    var distances: String? = null,
    var prices: List<String>? = null,
    var restaurantTypes: List<String>? = null,
    var ratings: List<String>? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    var north: Double? = null,
    var east: Double? = null,
    var south: Double? = null,
    var west: Double? = null
)