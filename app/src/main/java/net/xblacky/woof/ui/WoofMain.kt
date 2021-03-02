package net.xblacky.woof.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import net.xblacky.woof.data.FakeData
import net.xblacky.woof.navigation.Screen

@Composable
fun WoofMain(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            Home(navController, FakeData.dogList)
        }
        composable(
            "${Screen.Details.route}/{id}/",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            Details(navController, it.arguments?.getInt("id") ?: 0)
        }
    }
}