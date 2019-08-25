package com.dlucci.weather.forecast.di

import com.dlucci.weather.forecast.networking.ForecastService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ForecastModule {

    @Provides
    fun providesRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun providesForecastService(retrofit: Retrofit) =
        retrofit.create(ForecastService::class.java)
}