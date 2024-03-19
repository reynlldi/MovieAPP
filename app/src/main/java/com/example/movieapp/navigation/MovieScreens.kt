package com.example.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen,
    NotificationScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            NotificationScreen.name -> NotificationScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognition")
        }
    }
}