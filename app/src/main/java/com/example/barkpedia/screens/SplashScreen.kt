package com.example.barkpedia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.barkpedia.R
import com.example.barkpedia.ui.theme.Beige
import com.example.barkpedia.ui.theme.Brown
import com.example.barkpedia.ui.theme.Warm
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(
                Brown,
                Beige
            ))
            ),
        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.dog),
                contentDescription = "Icon",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "BarkPedia",
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "The one-stop dog info app",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Text(
            text = "onefactorial",
            style = TextStyle(fontSize = 20.sp)
        )
    }
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.popBackStack()
        navController.navigate("home_screen")
    }
}

@Preview
@Composable
fun Prev(){
    SplashScreen(navController = rememberNavController())
}