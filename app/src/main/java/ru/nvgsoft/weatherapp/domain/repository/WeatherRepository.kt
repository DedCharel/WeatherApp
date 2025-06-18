package ru.nvgsoft.weatherapp.domain.repository

import ru.nvgsoft.weatherapp.domain.entity.Forecast
import ru.nvgsoft.weatherapp.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}