package eu.epfc.tmdb.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import eu.epfc.tmdb.data.FavoritesRepository
import eu.epfc.tmdb.data.MoviesRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MovieListViewModel(private val moviesRepository: MoviesRepository, private val favoritesRepository: FavoritesRepository): ViewModel() {

//    private lateinit var _favorites: List<Int>

//    init {
//        viewModelScope.launch {
//            _favorites = favoritesRepository.getIds()
//        }
//    }

    private val _popular = moviesRepository.getPopular().cachedIn(viewModelScope).map { pagingData ->
        pagingData.map {
            Movie (
        id = it.id,
        title = it.title,
        voteAverage =  it.voteAverage,
        voteCount = it.voteCount,
        popularity = it.popularity,
        poster = it.poster,
        favorite = false // _favorites.contains(it.id)
            )
        }
    }

    fun getPopular() = _popular
//    val favorites = mutableStateOf(_favorites)

//    val popular: Flow<PagingData<Movie>>
//        get() = moviesRepository.getPopular().cachedIn(viewModelScope)
//
//
//    val topRated: Flow<PagingData<Movie>>
//        get() = moviesRepository.getTopRated().cachedIn(viewModelScope)


//    private fun mappingFields(pagingData: PagingData<eu.epfc.tmdb.network.model.Movie>) = pagingData.map { Movie (
//        id = it.id,
//        title = it.title,
//        voteAverage =  it.voteAverage,
//        voteCount = it.voteCount,
//        popularity = it.popularity,
//        poster = it.poster
//    )  }

}

data class Movie(
    val id: Int,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
    val poster: String,
    val favorite: Boolean

)