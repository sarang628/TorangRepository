package com.sarang.torang.data


data class Filter(
    var searchType: SearchType = SearchType.AROUND,
    var keyword: String? = null,
    var distances: String? = null,
    var prices: List<String>? = null,
    var restaurantTypes: List<String>? = null,
    var ratings: List<String>? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    var northEastLat: Double? = null,
    var northEastLon: Double? = null,
    var southWestLat: Double? = null,
    var southWestLon: Double? = null
){
    companion object
}