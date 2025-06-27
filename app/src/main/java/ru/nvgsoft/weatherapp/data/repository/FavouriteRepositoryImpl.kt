package ru.nvgsoft.weatherapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nvgsoft.weatherapp.data.local.db.FavouriteCitiesDao
import ru.nvgsoft.weatherapp.data.mapper.toDbModel
import ru.nvgsoft.weatherapp.data.mapper.toEntities
import ru.nvgsoft.weatherapp.domain.entity.City
import ru.nvgsoft.weatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {
    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouriteCitiesDao
        .observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) = favouriteCitiesDao
        .addFavourite(city.toDbModel())

    override suspend fun removeFromFavourite(cityId: Int) = favouriteCitiesDao
        .removeFavourite(cityId)
}