package com.dlucci.weather

import com.dlucci.utils.toFarenheit
import org.junit.Assert.assertTrue
import org.junit.Test

class WeatherXTensionTest {

    @Test
    fun testToFarenheith() {
        var kelvin = 288.45
        assertTrue(kelvin.toFarenheit() == "59.54")
    }
}