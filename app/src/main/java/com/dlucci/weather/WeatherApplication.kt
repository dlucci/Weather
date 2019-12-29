package com.dlucci.weather;

import android.app.Application
import org.koin.core.context.startKoin

class WeatherApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(com.dlucci.di.networkModule))
        }
    }

}
