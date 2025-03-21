package eu.epfc.tmdb.ui.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import eu.epfc.tmdb.data.MoviesRepository
import eu.epfc.tmdb.network.model.Movie
import eu.epfc.tmdb.ui.MoviesViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeScreen (modifier: Modifier = Modifier) {
    val moviesViewModel: MoviesViewModel = viewModel(factory = MoviesViewModel.Factory)
    GridOfItems(data = moviesViewModel.movies)
}

@Composable
fun GridOfItems(
    data: Flow<PagingData<Movie>>,
    modifier: Modifier = Modifier) {

    val movies = data.collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(1)
    ) {
        items(movies.itemCount) { index ->
            movies[index]?.let {
                MovieCard(
                    item = it
                )
            }
        }
    }

}

@Composable
fun MovieCard(
    item: Movie,
    modifier: Modifier = Modifier
) {
   Text(text = item.title)
}