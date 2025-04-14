package eu.epfc.tmdb.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.epfc.tmdb.network.TmdbClient
import kotlinx.coroutines.launch

class LoginViewModel (val tmdbClient: TmdbClient): ViewModel() {

    val connected  =  mutableStateOf(false)

    fun login() {
        connected.value = true
//        viewModelScope.launch { tmdbClient.getRequestToken() }
    }
}