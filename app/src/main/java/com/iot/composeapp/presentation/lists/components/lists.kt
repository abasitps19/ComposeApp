package com.iot.composeapp.presentation.lists.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        "Navigation Application", "Master Android Application",
        "Master Android Jetpack Compose Application",
        "Maser Kotlin Application"
    )
    LazyColumn() {
        items(itemsList){
            item ->
            Text(text = item)
    }

    }
}
