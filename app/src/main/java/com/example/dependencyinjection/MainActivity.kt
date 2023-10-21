package com.example.dependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dependencyinjection.ui.theme.DependencyInjectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DependencyInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Car()
                }
            }
        }
    }
}

//manual DI
@Composable
fun Car(
    mainViewModel: MainViewModel = viewModel(), modifier: Modifier = Modifier) {
    val mainUiState by mainViewModel.mainUiState.collectAsState()
    Column(){
        Text(
            text = "Car Engine ${mainUiState.carEngine}!",
            modifier = modifier
        )
        Text(
            text = "Car Fuel ${mainUiState.carFuelPump}!",
            modifier = modifier
        )
        Text(
            text = "Car Tire ${mainUiState.carTires}!",
            modifier = modifier
        )
    }


}