package com.example.barkpedia.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.barkpedia.data.DogsItem
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun DisplayData(dogList : MutableList<DogsItem>, navController: NavController) {
    var resultList = SearchFunction(dogList)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ){
        items(resultList) { dog ->
            CardView(dog,navController)
        }
    }
}

@Composable
fun CardView(dog: DogsItem, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(236.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "dogItem",
                    value = dog
                )
                navController.navigate("detail_screen")
            },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ){
            Image(
                painter = rememberImagePainter(dog.image!!.url),
                contentDescription = "Dog Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = dog.name!!,
                modifier = Modifier.fillMaxWidth()
                    .background(Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color.Black
                    )
                ), RectangleShape,1.0f)
                    .padding(20.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
