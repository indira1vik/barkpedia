package com.example.barkpedia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.barkpedia.data.DogsItem
import com.example.barkpedia.ui.theme.Beige
import com.example.barkpedia.ui.theme.Brown

@Composable
fun FavScreen(navController: NavController,favList: MutableList<DogsItem>){
    val favScreenName: String = "Your Favorite Dogs"
    Scaffold(
        topBar = { TopAppBar(text = favScreenName) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Beige, RectangleShape)
        ){
            if (favList.isEmpty()){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "The Favorite list is Empty")
                }
            } else{
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ){
                    items (favList){ item ->
                        CardView(dog = item, navController = navController)
                        RemoveFunction(item,favList)
                    }
                }
            }
        }
    }
}

@Composable
fun RemoveFunction(item: DogsItem, favList: MutableList<DogsItem>) {
    Box(modifier =Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
    ){
        OutlinedButton(onClick = {
            favList.remove(item)
        },modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp),
            shape = RoundedCornerShape(28.dp),
            colors =ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Brown
            )
        ) {
            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Remove")
            }
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
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        ), RectangleShape, 1.0f
                    )
                    .padding(20.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}