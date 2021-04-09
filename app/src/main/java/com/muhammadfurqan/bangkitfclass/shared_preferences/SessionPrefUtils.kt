package com.muhammadfurqan.bangkitfclass.shared_preferences

import android.content.SharedPreferences

/**
 * @author by furqan on 09/04/2021
 */
class SessionPrefUtils(private val sharedPreferences: SharedPreferences) {

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveData(key: String, value: Any) {
        when (value) {
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            else -> throw Throwable("The data type is not supported")
        }
    }

    fun applyEditor() {
        editor.apply()
    }

    fun getData(key: String, default: String): String =
        sharedPreferences.getString(key, default) ?: default

    fun getData(key: String, default: Boolean): Boolean =
        sharedPreferences.getBoolean(key, default)

    companion object {
        const val PREF_NAME = "session-f-class"

        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
        const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }

}