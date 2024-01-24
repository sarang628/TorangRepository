package com.sryang.torang_repository.data.remote.response

data class RemoteCity(
    val latitude: Double,
    val longitude: Double,
    val zoom: Float = 0f,
    val name: String,
    val url: String
)
