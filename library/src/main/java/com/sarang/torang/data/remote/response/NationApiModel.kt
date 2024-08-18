package com.sarang.torang.data.remote.response

data class NationApiModel(
    val latitude: Double,
    val longitude: Double,
    val zoom: Float = 0f,
    val name: String,
    val url: String
)