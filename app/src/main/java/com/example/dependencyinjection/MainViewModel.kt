package com.example.dependencyinjection

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainUiState(
    val carEngine: String = "" ,
    val carFuelPump: String="",
    val carTires: String=""
)
class MainViewModel : ViewModel(){

    //this is our state flow which holds the data amd emits new state updates
    private val _mainUiState= MutableStateFlow(MainUiState())
    //mutable state flows a read only state
    val mainUiState: StateFlow<MainUiState> = _mainUiState.asStateFlow()

    init{
        createCar()
    }
    fun createCar(){
        _mainUiState.value = MainUiState("ford", "leaky", "michelin")
    }

}