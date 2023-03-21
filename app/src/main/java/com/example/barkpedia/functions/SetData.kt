package com.example.barkpedia.functions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.barkpedia.DataState
import com.example.barkpedia.MainView
import com.example.barkpedia.data.DogsItem

@Composable
fun SetData(viewModel: MainView, navController: NavController) {
    when (val result = viewModel.response.value){
        is DataState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
                CircularProgressIndicator()
            }
        }
        is DataState.Failure -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
                Text(text = result.message, style = TextStyle(fontSize = 24.sp))
            }
        }
        is DataState.Success -> {
            DisplayData(dogList = result.data, navController = navController)
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
                Text(text = "Error in Fetching Data", style = TextStyle(fontSize = 24.sp))
            }
        }
    }
}