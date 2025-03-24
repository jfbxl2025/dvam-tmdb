package eu.epfc.tmdb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
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

    LazyColumn(

    ) {
        items(movies.itemCount) { index ->
            movies[index]?.let {
                MovieCard(
                    movie = it
                )
            }
        }
    }

}

@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column () {
            Text(text=movie.title)
//            Text(text=movie.poster_path?: " - (vide)")
            Row(
//                modifier = Modifier.height(100.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(text="Vote average: ${movie.voteAverage}")
                    Text(text="Popularity : ${movie.popularity}")
                    Text(text="Vote count: ${movie.voteCount}")
                }
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(movie.poster)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
        //            placeholder = painterResource(R.drawable.loading_img),
        //            error = painterResource(R.drawable.ic_broken_image),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .fillMaxWidth()
                    ,

                    )
            }
        }
    }
}