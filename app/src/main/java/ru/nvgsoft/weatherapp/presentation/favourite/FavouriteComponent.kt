package ru.nvgsoft.weatherapp.presentation.favourite

import kotlinx.coroutines.flow.StateFlow
import ru.nvgsoft.weatherapp.domain.entity.City

interface FavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun onClickAddToFavourite()

    fun onCityItemClick(city: City)
}