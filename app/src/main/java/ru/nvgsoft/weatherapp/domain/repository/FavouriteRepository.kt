package ru.nvgsoft.weatherapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.nvgsoft.weatherapp.domain.entity.City

interface FavouriteRepository {

    val favouriteCities: Flow<City>

    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    suspend fun addToFavourite(city: City)

    suspend fun removeFromFavourite(cityId: Int)
}