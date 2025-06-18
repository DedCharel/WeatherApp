package ru.nvgsoft.weatherapp.domain.usecase

import ru.nvgsoft.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(citiId: Int) = repository.getWeather(citiId)
}