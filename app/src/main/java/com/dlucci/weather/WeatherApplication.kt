package com.dlucci.weather;

import android.app.Application;
import com.dlucci.weather.forecast.di.networkModule
import org.koin.core.context.startKoin

class WeatherApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(networkModule))
        }
    }

}
