package ru.nvgsoft.weatherapp

import android.app.Application
import ru.nvgsoft.weatherapp.di.ApplicationComponent
import ru.nvgsoft.weatherapp.di.DaggerApplicationComponent

class WeatherApp: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}