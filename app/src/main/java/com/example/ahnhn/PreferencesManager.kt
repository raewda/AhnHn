package com.example.ahnhn

import android.content.Context
import android.content.SharedPreferences

class PreferenceManagerImpl
constructor(
    context: Context,
) {
    // сам экземпляр класса, который сохраняет это всё в файл
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("date", Context.MODE_PRIVATE)

    // ключ-значение перезапишет, если есть. если нет - создаст
    fun saveString(
        key: String,
        value: String,
    ) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    // получает строку по ключу. если ключа нет, то возвращает дефолтное значение
    fun getString(
        key: String,
        defaultValue: String? = null,
    ): String? = sharedPreferences.getString(key, defaultValue) ?: defaultValue
}
