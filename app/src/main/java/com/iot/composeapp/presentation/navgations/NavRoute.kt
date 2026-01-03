package com.iot.composeapp.presentation.navgations

sealed class NavRoute (val path: String){

    object Home: NavRoute("home")
    object Profile: NavRoute("profile"){
        val id = "id"
        val showDetails = "showDetails"
    }

}