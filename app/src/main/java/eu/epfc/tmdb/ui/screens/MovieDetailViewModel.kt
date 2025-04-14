package eu.epfc.tmdb.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import eu.epfc.tmdb.data.MovieRepository
import eu.epfc.tmdb.network.TmdbClient
import eu.epfc.tmdb.network.model.Details
import eu.epfc.tmdb.network.model.Favorite
import eu.epfc.tmdb.ui.MovieDetailsDestination
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val movieId = savedStateHandle.toRoute<MovieDetailsDestination>().movieId
    private var favorite = savedStateHandle.toRoute<MovieDetailsDestination>().favorite

    val details  =  mutableStateOf<Details>(Details())

    init {
        viewModelScope.launch {
            try {
                 details.value = movieRepository.getDetails(movieId)
            }
            catch (e:Exception) {
                Log.e("detail VM",e.message ?: "error")
            }
        }
    }


    fun addToFavorite() {
        viewModelScope.launch {
            try {
            movieRepository.addToFavorite( movieId )
            }
            catch (e:Exception) {
                Log.e("addToFavorite***",e.message ?: "error")
            }
        }
    }


}