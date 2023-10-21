package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.data.CarState

class MyApplication :Application() {
    //Because these dependencies are used across the whole
    // application, they need to be placed in a common place
    // all activities can use: the Application class

    //create the container for the app
    val appContainer = AppContainer().carRepository

}