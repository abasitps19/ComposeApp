package com.iot.composeapp.presentation.navgations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun Screen1Simple(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("This is First Screen",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Spacer(modifier = Modifier.height(12.dp))

            Button({
                navController.navigate("Second")
            }){
                Text("Click to 2nd Screen", fontSize = 20.sp)
            }
        }
    }

}

@Composable
fun Screen2Simple(navController : NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text("This is Second Screen",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Spacer(modifier = Modifier.height(12.dp))

            Button({
                //navController.navigate("first")
                navController.navigateUp()
            }){
                Text("Click to 1st Screen", fontSize = 20.sp)
            }
        }
    }

}


@Composable
fun Screen1Argu(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var enteredName by remember { mutableStateOf("") }
            var enteredAge by remember { mutableStateOf("") }

            Text("This is First Screen",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = enteredName,
                onValueChange = {enteredName = it},
                label = {Text(text="Enter Name")}
                )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = enteredAge,
                onValueChange = {enteredAge = it},
                label = {Text(text="Enter Age")}
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button({
                //passing as argument the text entered into Text Field Name
                navController.navigate("Second/$enteredName?age=$enteredAge")
            }){
                Text("Click to 2nd Screen", fontSize = 20.sp)
            }
        }
    }

}

@Composable
fun Screen2Argu(navController : NavController, userName: String, age: String){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome: $userName  Age: $age",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Spacer(modifier = Modifier.height(12.dp))

            Button({
                //navController.navigate("first")
                navController.navigateUp()
            }){
                Text("Click to 1st Screen", fontSize = 20.sp)
            }
        }
    }

}



@Preview
@Composable
fun PreviewScreens(){
    //Screen1()
    //Screen2()
}