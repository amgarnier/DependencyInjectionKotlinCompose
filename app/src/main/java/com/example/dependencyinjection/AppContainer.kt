package com.example.dependencyinjection

import com.example.dependencyinjection.data.CarState

class AppContainer {

    //we want to create our services here url etc
    //as an example I am creating my data source
    //this is our big container that gets the data

    //it is the container for our DI but in this case not used
    private val carDataSource = CarState("engine in app container", "leaky", "michelin")

    val carRepository = CarRepository(carDataSource)
}