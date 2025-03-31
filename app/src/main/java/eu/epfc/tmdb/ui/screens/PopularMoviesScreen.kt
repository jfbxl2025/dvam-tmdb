package eu.epfc.tmdb.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import eu.epfc.tmdb.network.model.Movie
import eu.epfc.tmdb.ui.TmdbViewModelProvider
import eu.epfc.tmdb.ui.components.MovieCard
import eu.epfc.tmdb.ui.components.TmdbScaffold


@Composable
fun PopularMoviesScreen (
    navigateToMovieDetail: (Int) ->Unit,
    moviesViewModel: MoviesViewModel = viewModel(factory = TmdbViewModelProvider.Factory),
    modifier: Modifier = Modifier
){
    val movies = moviesViewModel.getPopular().collectAsLazyPagingItems()

    TmdbScaffold(
        title = "Popular"
    ) {
        LazyColumn(
//            state = moviesViewModel.lazyListState,
            modifier = modifier.padding(it)
        ) {
            items(movies.itemCount) { index ->
                movies[index]?.let { movie ->
                    MovieCard(
                        index = index,
                        movie = movie,
                        onMovieClick = { navigateToMovieDetail(movie.id) }
                    )
                }
            }
        }
    }
}

