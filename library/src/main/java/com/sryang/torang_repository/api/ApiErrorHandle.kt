package com.sryang.torang_repository.api

import org.json.JSONObject
import retrofit2.HttpException

fun Exception.handle(): String {
    if (this is HttpException) {
        var msg = "알 수 없는 오류가 발생했습니다."
        this.response()?.errorBody()?.string()?.let {
            msg = JSONObject(it).getString("message")
        }
        return msg;
    }
    return "알 수 없는 오류가 발생했습니다."
}