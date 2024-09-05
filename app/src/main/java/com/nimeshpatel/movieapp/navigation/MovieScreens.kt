package com.nimeshpatel.movieapp.navigation

/**
 * Created by Nimesh Patel on 05-Aug-24.
 * Purpose:
 */

enum class MovieScreens{
    HomeScreen,
    DetailScreen;
    companion object{
        fun fromRoute(route:String?) : MovieScreens
         = when (route?.substringBefore("/")){
             HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
         }
    }
}