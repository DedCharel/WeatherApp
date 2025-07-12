package ru.nvgsoft.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import ru.nvgsoft.weatherapp.WeatherApp
import ru.nvgsoft.weatherapp.presentation.root.DefaultRootComponent
import ru.nvgsoft.weatherapp.presentation.root.RootContent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)

        super.onCreate(savedInstanceState)


        val root = rootComponentFactory.create(defaultComponentContext())


        setContent {
            RootContent(component = root)
        }
    }
}

