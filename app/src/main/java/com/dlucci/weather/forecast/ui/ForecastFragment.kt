package com.dlucci.weather.forecast.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.api.load
import com.dlucci.weather.R
import com.dlucci.weather.forecast.di.DaggerForecastComponent
import com.dlucci.weather.forecast.di.ForecastModule
import com.dlucci.weather.forecast.model.Forecast
import com.dlucci.weather.forecast.networking.ForecastService
import com.dlucci.weather.inflate
import com.dlucci.weather.toFarenheit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.forecast_fragment.currentCondition
import kotlinx.android.synthetic.main.forecast_fragment.icon
import kotlinx.android.synthetic.main.forecast_fragment.location
import kotlinx.android.synthetic.main.forecast_fragment.temperature
import javax.inject.Inject

class ForecastFragment : Fragment() {

    @Inject
    lateinit var service: ForecastService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return context?.inflate(container as ViewGroup, R.layout.forecast_fragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        var component = DaggerForecastComponent.builder()
            .forecastModule(ForecastModule())
            .build()

        component.inject(this)

        service.getCurrentWeather("London,uk", "1c9b44ce2c83f81848124307d216d1a9")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({ t -> showData(t) }, {t -> showError(t)})
    }

    private fun showError(t: Throwable?) {
        Toast.makeText(activity, t?.message, Toast.LENGTH_LONG).show()
    }

    private fun showData(forecast: Forecast?) {
        location.text = forecast?.name
        temperature.text = String.format("%s°F", forecast?.main?.temp?.toFarenheit())
        currentCondition.text = String.format("%s:  ", forecast?.weather?.get(0)?.description)
        icon.load("https://openweathermap.org/img/wn/${forecast?.weather?.get(0)?.icon}@2x.png"){
            error(R.mipmap.ic_launcher)
            placeholder(R.mipmap.ic_launcher_round)
        }
    }
}