package ru.nvgsoft.weatherapp.domain.usecase

import ru.nvgsoft.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String) = repository.search(query)
}