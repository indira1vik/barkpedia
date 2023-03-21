package com.example.barkpedia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.barkpedia.MainView
import com.example.barkpedia.data.DogsItem
import com.example.barkpedia.functions.SetData
import com.example.barkpedia.ui.theme.Beige
import com.example.barkpedia.ui.theme.Black
import com.example.barkpedia.ui.theme.Brown
import com.example.barkpedia.ui.theme.Warm

@Composable
fun HomeScreen(navController: NavController,viewModel: MainView){
    val appName = "BarkPedia"
    Scaffold(
        topBar = { TopAppBar(appName) },
        bottomBar = { BottomAppBar(navController) }
    ) {
        Contents(viewModel,navController)
    }
}

@Composable
fun TopAppBar(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Beige, RectangleShape)
            .padding(vertical = 15.dp),
        contentAlignment = Alignment.Center
    ){
        Text(text = text, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BottomAppBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        FloatingActionButton(onClick = {
            navController.navigate("fav_screen")
        },
        backgroundColor = Black) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "FavIcon", tint = White)
        }
    }
}

@Composable
fun Contents(viewModel: MainView, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(Beige, RectangleShape)) {
        SetData(viewModel = viewModel,navController = navController)
    }
}
