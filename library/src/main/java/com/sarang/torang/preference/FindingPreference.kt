package com.sarang.torang.preference

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@Singleton
open class FindingPreference @Inject constructor(@ApplicationContext val context: Context) {

    val pref: SharedPreferences = context.getSharedPreferences("Finding", Context.MODE_PRIVATE)

    fun setCurrentRestaurantId(restaurantId: Int) { pref.edit() { putInt("currentRestaurantId", restaurantId) } }

    fun getCurrentRestaurantIdFlow(): Flow<Int> = callbackFlow {
        trySend(pref.getInt("currentRestaurantId", -1))
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == "currentRestaurantId") { trySend(pref.getInt("currentRestaurantId", -1)) }
        }
        pref.registerOnSharedPreferenceChangeListener(listener)
        awaitClose { pref.unregisterOnSharedPreferenceChangeListener(listener) }
    }
}