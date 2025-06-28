package ru.nvgsoft.weatherapp.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.nvgsoft.weatherapp.data.local.db.FavouriteCitiesDao
import ru.nvgsoft.weatherapp.data.local.db.FavouriteDatabase
import ru.nvgsoft.weatherapp.data.network.api.ApiFactory
import ru.nvgsoft.weatherapp.data.network.api.ApiService
import ru.nvgsoft.weatherapp.data.repository.FavouriteRepositoryImpl
import ru.nvgsoft.weatherapp.data.repository.SearchRepositoryImpl
import ru.nvgsoft.weatherapp.data.repository.WeatherRepositoryImpl
import ru.nvgsoft.weatherapp.domain.repository.FavouriteRepository
import ru.nvgsoft.weatherapp.domain.repository.SearchRepository
import ru.nvgsoft.weatherapp.domain.repository.WeatherRepository

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository


    companion object{

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDateBase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}