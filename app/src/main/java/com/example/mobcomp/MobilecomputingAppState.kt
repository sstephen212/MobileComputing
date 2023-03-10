package com.example.mobcomp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class MobileComputingAppState(
    val navController:NavHostController
){
    fun navigateBack(){
        navController.popBackStack()
    }
}
@Composable
fun rememberMobileComputingAppState(
    navCotroller: NavHostController = rememberNavController()
) = remember(navCotroller){
    MobileComputingAppState(navCotroller)
}