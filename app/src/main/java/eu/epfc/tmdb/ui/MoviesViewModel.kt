package eu.epfc.tmdb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import eu.epfc.tmdb.TmdbApplication
import eu.epfc.tmdb.data.MoviesRepository
import eu.epfc.tmdb.network.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class MoviesViewModel(private val moviesRepository: MoviesRepository): ViewModel() {

    val movies: Flow<PagingData<Movie>>
        get() = moviesRepository.getMoviesStream().cachedIn(viewModelScope)
//            .map { pagingList ->
//            pagingList.filter { movie -> movie.posterPath != null }
//        }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TmdbApplication)
                val moviesRepository = application.container.moviesRepository
                MoviesViewModel(moviesRepository = moviesRepository)
            }
        }
    }
}