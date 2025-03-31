package eu.epfc.tmdb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import eu.epfc.tmdb.network.model.Movie
import eu.epfc.tmdb.ui.TmdbViewModelProvider
import eu.epfc.tmdb.ui.components.MovieCard
import eu.epfc.tmdb.ui.components.TmdbScaffold

@Composable
fun MovieDetailScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MovieDetailsViewModel = viewModel(factory = TmdbViewModelProvider.Factory)
) {
    val details = viewModel.details.value

    TmdbScaffold(
        title = "Detail Movie",
        canNavigateBack = true,
        navigateUp = navigateBack
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding))
        {
            Text(text = "title ${details.title}")
            Button(
                onClick = {viewModel.addToFavorite()}
            ) { }
        }
    }

}