package com.example.callbreathinglight

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.callbreathinglight.ui.router.RouterManage
import com.example.callbreathinglight.ui.screen.AddScreen
import com.example.callbreathinglight.ui.screen.MainScreen
import com.example.callbreathinglight.ui.screen.SettingsScreen

/**
 *@author :ckx
 *@since: 2024/6/9
 *作用：
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouterManage.MainScreen) {
        composable(RouterManage.MainScreen) { MainScreen(navController) }
        composable(RouterManage.SettingsScreen) { SettingsScreen() }
        composable(RouterManage.AddScreen) { AddScreen() }
    }
}