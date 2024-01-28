package com.sarang.torang.data.remote.response

class Response<T>(
    var status: Int,
    var data: T? = null,
    var errorMessage: String? = null
)