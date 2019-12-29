package com.dlucci.networking


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("weather")
    fun getCurrentWeather(
        @Query("q") location: String,
        @Query("appId") key: String
    ): Observable<Forecast>
}