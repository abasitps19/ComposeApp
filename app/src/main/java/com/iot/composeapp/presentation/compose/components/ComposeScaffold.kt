package com.iot.composeapp.presentation.compose.components

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.iot.composeapp.R
import com.iot.composeapp.presentation.lists.components.CustomLazyColumn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(context: Context){

    TopAppBar(
        title = {Text(text="Top App Bar")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Green,
            titleContentColor=Color.Blue
        ),
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Clicked on the Nav Icon",
                    Toast.LENGTH_LONG).show()

            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription="Menu")
            }
        },
        actions ={
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Clicked on Action",
                    Toast.LENGTH_LONG
                ).show()
            }){
                Icon(painter = painterResource(id=R.drawable.baseline_build_24),
                    contentDescription = "Settings")

            }

        }
    )
}

@Composable
fun CustomBottonBar(context: Context){
    BottomAppBar(
        containerColor = Color.DarkGray,
        contentColor = Color.Yellow) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Clicked on 1st ICON",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Icon(painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = "Home")
            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Clicked on 2nd ICON",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Icon(painter = painterResource(R.drawable.baseline_collections_bookmark_24),
                    contentDescription = "Bookmark")
            }

            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Clicked on 3rd ICON",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Icon(painter = painterResource(R.drawable.baseline_people_24),
                    contentDescription = "People")
            }
        }
    }
}

@Composable
fun CustomFAB(context: Context){

    FloatingActionButton(onClick = {
        Toast.makeText(context,"Clicked on FAB", Toast.LENGTH_SHORT).show()
    }) {

        IconButton(onClick = {
            Toast.makeText(
                context,
                "Clicked on 3rd ICON",
                Toast.LENGTH_LONG
            ).show()
        }) {
            Icon(painter = painterResource(R.drawable.baseline_add_24),
                contentDescription = "FAB")
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanfActivity(context: Context ){
    Scaffold(
        topBar = {
            CustomTopAppBar(context)
        },
        bottomBar = {
            CustomBottonBar(context)
        },
        floatingActionButton = {
            CustomFAB(context)
        }

    ) {
        CustomLazyColumn()
    }
}
