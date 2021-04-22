package com.olabode.wilson.moovy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.olabode.wilson.moovy.screens.Routes
import com.olabode.wilson.moovy.screens.detail.MovieDetailScreen
import com.olabode.wilson.moovy.screens.home.HomeScreen
import com.olabode.wilson.moovy.ui.theme.MoovyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()
    val detailViewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoovyTheme {
                ScreenNavigator(mainViewModel, detailViewModel = detailViewModel)
            }
        }
    }
}

@Composable
fun ScreenNavigator(viewModel: MainViewModel,detailViewModel: MovieDetailViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(navController, viewModel = viewModel)
        }

        composable(
            "${Routes.DETAIL}/{${Routes.DETAIL_ARG}}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            MovieDetailScreen(
                navController,
                arguments.getInt("movieId", -1),
                detailViewModel
            )
        }
    }

}