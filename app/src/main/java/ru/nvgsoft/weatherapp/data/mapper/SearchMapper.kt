package ru.nvgsoft.weatherapp.data.mapper

import ru.nvgsoft.weatherapp.data.network.dto.CityDto
import ru.nvgsoft.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }