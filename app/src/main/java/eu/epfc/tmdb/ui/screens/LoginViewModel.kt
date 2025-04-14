package eu.epfc.tmdb.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.epfc.tmdb.network.TmdbClient
import eu.epfc.tmdb.network.TmdbService
import kotlinx.coroutines.launch

class LoginViewModel (tmdbClient: TmdbClient): ViewModel() {

    fun login() {

        viewModelScope.launch { tmdbClient }
    }
}