package ru.nvgsoft.weatherapp.data.mapper

import ru.nvgsoft.weatherapp.data.local.model.CityDbModel
import ru.nvgsoft.weatherapp.domain.entity.City

fun CityDbModel.toEntity(): City = City(id, name, country)

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }