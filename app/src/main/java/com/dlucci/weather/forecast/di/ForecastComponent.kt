package com.dlucci.weather.forecast.di

import com.dlucci.weather.forecast.ui.ForecastFragment
import dagger.Component

@Component(modules = [ForecastModule::class])
interface ForecastComponent {

    fun inject(fragment: ForecastFragment)
}