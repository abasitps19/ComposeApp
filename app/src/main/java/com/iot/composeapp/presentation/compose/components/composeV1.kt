package com.iot.composeapp.presentation.compose.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Counter(){

    var counter by remember { mutableStateOf(value = 0)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Add this
            modifier = Modifier.fillMaxWidth() // Optional: make Column full width
        ) {
            Text(
                "counter value $counter",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = {
                if(counter< 50) {
                    counter++
                }else{
                    counter =0
                }
                Log.v("CLD", "Counter:  $counter")
            }
            ) {
                Text("Click")
            }
        }
    }

}

@Composable
fun TextAndButtons( ){
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Add this
            modifier = Modifier.fillMaxWidth() // Optional: make Column full width
        ) {
            TextField(
                value= text,
                onValueChange = {
                        newText -> text = newText
                },
                label = {Text("Enter Text")}
            )
            Text(text="Received: $text")

        }



    }
}

@Preview
@Composable
fun PreviewStates(){
    //Counter()
    TextAndButtons()
}