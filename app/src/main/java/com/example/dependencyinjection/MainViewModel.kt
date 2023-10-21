package com.example.dependencyinjection

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.savedstate.SavedStateRegistryOwner
import com.example.dependencyinjection.data.CarState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


//lets not create the car here lets just pass it in
class MainViewModel(private val carRepository: CarRepository) : ViewModel() {

    //fun to do stuff with data or just get the original data
    fun login() : CarState {
        return carRepository.updateData()
    }


    // Define ViewModel factory in a companion object
    //https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val carRepository = (this[APPLICATION_KEY] as MyApplication).appContainer
                MainViewModel(
                    carRepository = carRepository
                )
            }
        }
    }

}
