package com.example.mobcomp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.mobcomp.ui.home.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobcomp.ui.login.Login
import com.example.mobcomp.ui.reminder.Reminder

@Composable
fun MobileComputingApp(
    appState:MobileComputingAppState = rememberMobileComputingAppState()
)
{
    NavHost(
        navController = appState.navController,
        startDestination = "login"
    ){
        composable(route = "login") {
           Login(navController = appState.navController)

        }
        composable(route = "home") {
            //Login(navController = appState.navController)
            Home(
                navController = appState.navController
            )

        }
        composable(route = "reminder") {
            //Login(navController = appState.navController)
            Reminder(onBackPress = appState::navigateBack)

        }
    }
}