package com.sryang.torang_repository.session

import android.content.Context

class SessionService(context: Context) {
    val pref = context.getSharedPreferences("torang", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        pref.edit().putString("token", token).apply()
    }

    fun getToken(): String? {
        return pref.getString("token", "")
    }

    fun removeToken() {
        pref.edit().putString("token", null).apply()
    }
}