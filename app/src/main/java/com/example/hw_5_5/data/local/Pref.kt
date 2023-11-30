package com.example.hw_5_5.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(val preferences: SharedPreferences) {

    fun isShow(): Boolean {
        return preferences.getBoolean(SHOWED_KEY, false)
    }

    fun onShowed() {
        preferences.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object {
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
    }
}

