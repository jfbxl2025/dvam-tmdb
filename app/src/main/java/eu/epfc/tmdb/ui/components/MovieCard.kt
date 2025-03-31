package eu.epfc.tmdb.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import eu.epfc.tmdb.ui.screens.Movie


@Composable
fun MovieCard(
    index: Int,
    movie: Movie,
    onMovieClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .clickable { onMovieClick() },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

    ) {
        Column () {
            Text(text = index.toString())
            Text(text = movie.title)
            Row(
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(text="Vote average: ${movie.voteAverage}")
                    Text(text="Popularity : ${movie.popularity}")
                    Text(text="Vote count: ${movie.voteCount}")
                    if(movie.favorite) {
                        Text(text="Favorite")
                    }
                }
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(movie.poster)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
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