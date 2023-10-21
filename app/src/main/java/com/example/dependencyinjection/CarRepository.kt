package com.example.dependencyinjection

import com.example.dependencyinjection.data.CarState

class CarRepository(
    private val carState: CarState)
{
    //functions that do things to the data like get it and set it
    fun updateData(): CarState {

        carState.carTires="in car repo update data"
        return carState

    }

}