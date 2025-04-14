package eu.epfc.tmdb.ui.screens



import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems

import eu.epfc.tmdb.ui.TmdbViewModelProvider
import eu.epfc.tmdb.ui.components.MovieCard
import eu.epfc.tmdb.ui.components.TmdbScaffold




@Composable
fun MovieListScreen (
    navigateToMovieDetail: (Pair<Int, Boolean>) -> Unit,
    movieListViewModel: MovieListViewModel = viewModel(factory = TmdbViewModelProvider.Factory),
    modifier: Modifier = Modifier
) {

    TmdbScaffold(
        title = "Movie List screen"
    ) {

        val movies = movieListViewModel.getPopular().collectAsLazyPagingItems()

        LazyColumn(
            modifier = modifier.padding(it)
        ) {

            items(
                movies.itemCount,
//                key = movies.itemKey { it.id}
            ) { index ->
                movies[index]?.let { movie ->
                    MovieCard(
                        index = index,
                        movie = movie,
                        onMovieClick = { navigateToMovieDetail(Pair(movie.id, movie.favorite)) }
                    )
                }
            }
        }

    }


}





