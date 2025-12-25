package com.iot.composeapp.presentation.lists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iot.composeapp.R


@Composable
fun ScrollingColumn(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription ="Pic 1" ,
            contentScale = ContentScale.FillBounds)
        Image(
            painter = painterResource(id = R.drawable.pic2),
            contentDescription ="Pic 2",
            contentScale = ContentScale.FillBounds )
        Image(
            painter = painterResource(id = R.drawable.pic3),
            contentDescription ="Pic 3",
            contentScale = ContentScale.FillBounds) }
}

@Composable
fun ScrollingRow(){
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription ="Pic 1" ,
            contentScale = ContentScale.FillBounds)
        Image(
            painter = painterResource(id = R.drawable.pic2),
            contentDescription ="Pic 2",
            contentScale = ContentScale.FillBounds )
        Image(
            painter = painterResource(id = R.drawable.pic3),
            contentDescription ="Pic 3",
            contentScale = ContentScale.FillBounds)
    }
}

@Composable
fun CustomLazyColumn(){
    val itemsList = listOf<String>(
        "Master Coding Application",
        "Master Fluter Application",
        "Navigation Application",
        "Master Android Application",
        "Master Android Jetpack Compose Application",
        "Maser Kotlin Application",
        "Master Coding Application",
        "Master Fluter Application",
        "Navigation Application",
        "Master Android Application",
        "Master Android Jetpack Compose Application",
        "Maser Kotlin Application",
        "Social Activity",
        "Instagram",
        "Twitter",
        "Documentaries",
        "You-Tube",
        "Instagram",
        "Twitter",
        "Documentaries",
        "You-Tube",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "Master Coding Application",
        "Master Fluter Application",
        "Navigation Application",
        "Master Android Application",
        "Master Android Jetpack Compose Application",
        "Maser Kotlin Application",
        "Master Coding Application",
        "Master Fluter Application",
        "Navigation Application",
        "Master Android Application",
        "Master Android Jetpack Compose Application",
        "Maser Kotlin Application",
        "Social Activity",
        "Instagram",
        "Twitter",
        "Documentaries",
        "You-Tube",
        "Instagram",
        "Twitter",
        "Documentaries",
        "You-Tube",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit",
        "I hate hostel Life",
        "Every one should extreme closer is not fear",
        "You must remain inside yours boundaries",
        "Minus one formula is not acceptable",
        "Hesitation is not good practice",
        "down yourself to be grown",
        "Experimental life is not good habit"
    )


    Box(
           modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 110.dp, horizontal = 12.dp),
           contentAlignment = Alignment.Center
    ){

        LazyColumn() {
            stickyHeader {
                    Text("My Lists",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.background(Color.Blue)

                    )
            }

            item{
                Text("Item list",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp)
            }
            items(itemsList) { item ->
                Text(text = item,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CustomLazyRows(){
    val itemList = listOf<String>("Item 1", "Item 2", "Item 3",
        "Item 4", "Item 5", "Item 6",
        "Item 7", "Item 8", "Item 9",
        "Item 10", "Item 11", "Item 12")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyRow() {
            items(itemList) { item ->
                Text(text = item,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic)

            }
        }
    }
}
