package com.example.barkpedia.functions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.barkpedia.data.DogsItem
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun SearchFunction(dogList: MutableList<DogsItem>): MutableList<DogsItem>{
    val toSearch = remember { mutableStateOf(TextFieldValue("")) }
    SearchFieldWithIcons(toSearch = toSearch)
    val searchedText = toSearch.value.text
    if (searchedText.isEmpty()){
        dogList.shuffle()
        return dogList
    } else{
        val resultList = ArrayList<DogsItem>()
        for (item in dogList){
            if (item.name!!.lowercase(Locale.getDefault())
                    .contains(searchedText
                        .lowercase(Locale.getDefault())
                    )
            ) {
                resultList.add(item)
            }
        }
        return resultList
    }
}

@Composable
fun SearchFieldWithIcons(toSearch: MutableState<TextFieldValue>) {
    OutlinedTextField(
        value = toSearch.value,
        onValueChange = {
            toSearch.value = it
        },
        leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "SearchIcon") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        placeholder = { Text(text = "Search here") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black,
            leadingIconColor = Color.Black,
            focusedBorderColor = Color.Black,
            cursorColor = Color.Black
        )
    )
}