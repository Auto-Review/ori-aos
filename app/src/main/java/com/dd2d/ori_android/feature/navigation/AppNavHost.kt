package com.dd2d.ori_android.feature.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dd2d.ori_android.feature.screen_main.MainScreen
import com.dd2d.ori_android.feature.screen_sign_in.SignInScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: AppDestination
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<AppDestination.SignIn> {
            SignInScreen(
                onSignIn = {
                    navController.navigate(AppDestination.Main) {
                        popUpTo(AppDestination.SignIn) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable<AppDestination.Main> {
            MainScreen()
        }
    }
}