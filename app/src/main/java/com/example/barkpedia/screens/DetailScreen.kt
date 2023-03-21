package com.example.barkpedia.screens

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberImagePainter
import com.example.barkpedia.data.DogsItem
import com.example.barkpedia.data.Image
import com.example.barkpedia.ui.theme.Beige
import com.example.barkpedia.ui.theme.Brown

@Composable
fun DetailScreen(dogsItem: DogsItem, favList: MutableList<DogsItem>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            Image(
                painter = rememberImagePainter(dogsItem.image?.url!!),
                contentDescription = "Dog Item",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .background(Color.White, RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                .background(Beige, RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.TopCenter
        ){
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .zIndex(2F)
                    .padding(20.dp)
            ){
                val context = LocalContext.current
                Button(onClick = {
                    showToast(context)
                    addToFav(dogsItem, favList)
                },
                    modifier = Modifier,
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(Brown,Color.White)
                ) {
                    Box(
                        modifier = Modifier.padding(8.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "I Love them 💖")
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    dogsItem.name!!,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp
                )
                CardView(title = "Life Span", desc = dogsItem.life_span!!)
                CardView(title = "Height (Imperial)", desc = dogsItem.height!!.imperial.toString())
                CardView(title = "Weight (Imperial)", desc = dogsItem.weight!!.imperial.toString())
                val list: List<String> = dogsItem.temperament!!.split(", ")
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 20.dp, 0.dp, 0.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(12.dp))
                ){
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(text = "Temperament", fontSize = 16.sp)
                        for (i in list) {
                            Text(text = i, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
    }
}

private fun showToast(context: Context){
    Toast.makeText(context,"Added to Favorites",Toast.LENGTH_SHORT).show()

}

fun addToFav(dogsItem: DogsItem, favList: MutableList<DogsItem>){
    if (!favList.contains(dogsItem)){
        favList.add(dogsItem)
    }
}

@Composable
fun CardView(title: String,desc: String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(12.dp))
    ){
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = title, fontSize = 16.sp)
            Text(text = desc, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}