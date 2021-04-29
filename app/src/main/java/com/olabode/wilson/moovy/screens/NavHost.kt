package com.olabode.wilson.moovy.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.olabode.wilson.moovy.screens.detail.MovieDetailScreen
import com.olabode.wilson.moovy.screens.home.HomeScreen
import com.olabode.wilson.moovy.screens.search.SearchScreen

@Composable
fun ScreenNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                hiltNavGraphViewModel(),
                navigateToMovieDetail = { id ->
                    navController.navigate("${Routes.DETAIL}/${id}")
                },
                navigateToSearchScreen = {
                    navController.navigate(Routes.SEARCH)
                }
            )
        }

        composable(
            "${Routes.DETAIL}/{${Routes.DETAIL_ARG}}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            MovieDetailScreen(
                arguments.getInt("movieId", -1),
                hiltNavGraphViewModel()
            ) {
                navController.navigateUp()
            }
        }

        composable(Routes.SEARCH) {
            SearchScreen(
                hiltNavGraphViewModel(),
                navigateToMovieDetail = { id ->
                    navController.navigate("${Routes.DETAIL}/${id}")
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}