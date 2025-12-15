package com.sarang.torang.data

data class Search(
    val key: Long = System.currentTimeMillis(),
    var keyword: String,
    var createDate: String = key.toString()
){
    companion object
}
