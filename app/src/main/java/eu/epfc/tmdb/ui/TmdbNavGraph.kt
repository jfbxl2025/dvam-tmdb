package eu.epfc.tmdb.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.epfc.tmdb.ui.screens.HomeScreen
import eu.epfc.tmdb.ui.screens.LoginScreen
import eu.epfc.tmdb.ui.screens.MovieDetailScreen
import eu.epfc.tmdb.ui.screens.MovieListScreen
import eu.epfc.tmdb.ui.screens.PopularMoviesScreen
import kotlinx.serialization.Serializable

@Serializable object HomeDestination
@Serializable object LoginDestination
@Serializable object MoviePopularDestination
@Serializable object MovieListDestination
@Serializable data class MovieDetailsDestination(val movieId: Int, val favorite: Boolean)

@Composable
fun TmdbNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = LoginDestination
    ) {
        composable<HomeDestination> {
           HomeScreen(
               navigateToMovieDetail = { navController.navigate(MovieDetailsDestination(movieId = it.first, favorite = it.second )) }
           )
        }
        composable<LoginDestination> {
            LoginScreen(
                navigateToConnected = { navController.navigate(MovieListDestination) }
            )
        }

        composable<MovieListDestination> {
            MovieListScreen(
                navigateToMovieDetail = { navController.navigate(MovieDetailsDestination(movieId = it.first, favorite = it.second )) }
            )
        }

        composable<MovieDetailsDestination> {
            MovieDetailScreen(
                navigateBack = { navController.navigateUp() }
            )
        }


    }
}