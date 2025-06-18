package ru.nvgsoft.weatherapp.domain.repository

import ru.nvgsoft.weatherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}