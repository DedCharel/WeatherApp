package ru.nvgsoft.weatherapp.data.repository

import ru.nvgsoft.weatherapp.data.mapper.toEntities
import ru.nvgsoft.weatherapp.data.network.api.ApiService
import ru.nvgsoft.weatherapp.domain.entity.City
import ru.nvgsoft.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {
    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}