package com.iot.composeapp.navigationApp.navgations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


@Composable
fun NavGraph(navController: NavHostController){

}

fun AddHomeScreen(navController: NavHostController,
                     navGraphBuilder: NavGraphBuilder){
    //define a nav distinction
    navGraphBuilder.composable(
        route = NavRoute.Home.path
    ){

    }

}