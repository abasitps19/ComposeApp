package com.iot.composeapp.navigationApp.navgations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.serialization.generateRouteWithArgs
import com.iot.composeapp.navigationApp.screens.HomeScreen
import com.iot.composeapp.navigationApp.screens.ProfileScreen
import com.iot.composeapp.navigationApp.screens.SettingScreen


@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavRoute.Home.path){
        addHomeScreen(
            navController,this
        )
        addProfileScreen(navController,this)
        addSettingsScreen(navController,this)

    }
}


fun addHomeScreen(navController: NavHostController,
                     navGraphBuilder: NavGraphBuilder){
    //define a nav distinction
    navGraphBuilder.composable(
        route = NavRoute.Home.path
    ){
        //navBackStackEntry
        HomeScreen(
            navigateToProfile=
                { id, showDetails ->
                    navController.navigate(
                        NavRoute.Profile.path.plus("/$id/$showDetails")
                        //NavRoute.Profile.path.plus(id.toString()).plus(showDetail.toString())
                    )
                },
            navigateToSettings =
                {
                    navController.navigate(NavRoute.Settings.path)

                }
        )
    }
}
fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(
        route = NavRoute.Profile.path.plus("/{id}/{showDetails}"),
        arguments= listOf(
            navArgument(NavRoute.Profile.id){
                type = NavType.IntType
            },
            navArgument(NavRoute.Profile.showDetails){
                type = NavType.BoolType
            }
        )
    ){
        navBackStackEntry ->
        val args =  navBackStackEntry.arguments
        ProfileScreen(
            id = args?.getInt(NavRoute.Profile.id)!!,
            showDetails = args.getBoolean(NavRoute.Profile.showDetails),
            navigateToSettings = { navController.navigate(NavRoute.Settings.path)}
        )
    }
}

fun addSettingsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route= NavRoute.Settings.path){
        SettingScreen(
            navigateToHome = { navController
                .navigate(NavRoute.Home.path)}
        )
    }
}