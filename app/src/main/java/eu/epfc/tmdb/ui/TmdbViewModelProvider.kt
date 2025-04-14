package eu.epfc.tmdb.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import eu.epfc.tmdb.TmdbApplication
import eu.epfc.tmdb.network.TmdbService
import eu.epfc.tmdb.ui.screens.LoginViewModel
import eu.epfc.tmdb.ui.screens.MovieDetailsViewModel
import eu.epfc.tmdb.ui.screens.MovieListViewModel

object TmdbViewModelProvider {
        val Factory = viewModelFactory {

            initializer {
                LoginViewModel(tmdbClient = TmdbService.tmdbClient)
            }
            initializer {
                val container = inventoryApplication().container
                MovieListViewModel(container.moviesRepository, container.favoritesRepository)
            }

            initializer {
                MovieDetailsViewModel(this.createSavedStateHandle(), inventoryApplication().container.movieRepository)
            }


    }


    private fun CreationExtras.inventoryApplication(): TmdbApplication =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TmdbApplication)
}