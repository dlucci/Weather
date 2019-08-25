package com.dlucci.weather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import java.math.RoundingMode
import java.text.DecimalFormat

fun View.setNavigate(action: Int, bundle: Bundle) =
    this.setOnClickListener(Navigation.createNavigateOnClickListener(action, bundle))

fun Context.inflate(parent: ViewGroup, id: Int): View {
    var layoutInflater: LayoutInflater =
        this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return layoutInflater.inflate(id, parent, false)
}

fun Double.toFarenheit() : String {
    var df = DecimalFormat("###.##")
    df.roundingMode = RoundingMode.FLOOR
    return df.format((288.45-273.15) * (9/5.0) + 32).toDouble().toString()
}