package ru.nvgsoft.weatherapp.data.mapper

import android.icu.util.Calendar
import ru.nvgsoft.weatherapp.data.network.dto.WeatherCurrentDto
import ru.nvgsoft.weatherapp.data.network.dto.WeatherDto
import ru.nvgsoft.weatherapp.data.network.dto.WeatherForecastDto
import ru.nvgsoft.weatherapp.domain.entity.Forecast
import ru.nvgsoft.weatherapp.domain.entity.Weather
import java.util.Date

fun WeatherCurrentDto.toEntity() :  Weather = current.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = conditionDto.text,
    conditionUrl = conditionDto.iconUrl.correctUrl(),
    date = date.toCalendar()
)


fun WeatherForecastDto.toEntity() = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDay.drop(1).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.conditionDto.text,
            conditionUrl = dayWeatherDto.conditionDto.iconUrl.correctUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)
private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

private fun String.correctUrl(): String = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)