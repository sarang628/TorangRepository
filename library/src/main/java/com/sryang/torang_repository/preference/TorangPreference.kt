package com.sryang.torang_repository.preference

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class TorangPreference @Inject constructor(@ApplicationContext val context: Context) {

    val pref = context.getSharedPreferences("Torang", Context.MODE_PRIVATE)

    fun saveAccessToken(accessToken: String) {
        pref.edit().putString("accessToken", accessToken).apply()
    }

    fun getAccessToken(): String? {
        return pref.getString("accessToken", "")
    }

    fun saveUserId(userId: Int) {
        pref.edit().putInt("userId", userId).apply()
    }

    fun getUserId(): Int {
        return 0
    }

    fun saveLat(lat: Double) {
        pref.edit().putString("lat", lat.toString()).apply()
    }

    fun saveLon(lon: Double) {
        pref.edit().putString("lon", lon.toString()).apply()
    }

    fun loadLat(): Double {
        return pref.getString("lat", "0")!!.toDouble()
    }

    fun loadLon(): Double {
        return pref.getString("lon", "0")!!.toDouble()
    }

    fun saveZoom(level: Float) {
        pref.edit().putFloat("zoom", level).apply()
    }

    fun loadZoom(): Float {
        return pref.getFloat("zoom", 0f)
    }
}