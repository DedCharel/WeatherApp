package ru.nvgsoft.weatherapp.data.repository

import ru.nvgsoft.weatherapp.data.mapper.toEntity
import ru.nvgsoft.weatherapp.data.network.api.ApiService
import ru.nvgsoft.weatherapp.domain.entity.Forecast
import ru.nvgsoft.weatherapp.domain.entity.Weather
import ru.nvgsoft.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): WeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }

    companion object{
        private const val PREFIX_CITY_ID = "id:"
    }
}