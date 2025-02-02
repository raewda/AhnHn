package com.example.ahnhn.dcl

import android.app.Application

class ZodiacApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}