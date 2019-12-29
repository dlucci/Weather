package com.dlucci.networking

import com.google.gson.annotations.SerializedName

data class Forecast(
    var weather: Array<Weather>,
    var main: Current,
    var name: String
)

data class Weather(
    var main: String,
    var description: String,
    var icon: String
)

data class Current(
    var temp: Double,
    var humidity: Double,
    @SerializedName("temp_min") var tempMin: Double,
    @SerializedName("temp_max") var tempMax: Double
)