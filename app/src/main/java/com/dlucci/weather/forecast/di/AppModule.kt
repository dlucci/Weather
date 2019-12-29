package com.dlucci.weather.forecast.di


import com.dlucci.new_networking.ForecastService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Retrofit>(named(DEFAULT_NAMESPACE)) { createRetrofit() }
    single { createService(get(named(DEFAULT_NAMESPACE))) }
}

fun createService(retrofit: Retrofit) = retrofit.create(ForecastService::class.java)

fun createRetrofit() = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/data/2.5/")
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()


const val DEFAULT_NAMESPACE = "weather"