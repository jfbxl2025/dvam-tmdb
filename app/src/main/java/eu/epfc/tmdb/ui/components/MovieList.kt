//package eu.epfc.tmdb.ui.components
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.paging.PagingData
//import androidx.paging.compose.collectAsLazyPagingItems
//import eu.epfc.tmdb.ui.screens.Movie
//import eu.epfc.tmdb.ui.screens.rememberLazyListState
//import kotlinx.coroutines.flow.Flow
//
//@Composable
//fun MovieList(
//    movies: Flow<PagingData<Movie>>,
//    modifier: Modifier,
//    onMovieClick: (movie: Movie) -> Unit
//) {
//
//    val lazyMovieItems = movies.collectAsLazyPagingItems()
//
//    val listState = lazyMovieItems.rememberLazyListState()
//
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        modifier = modifier,
//        state = listState
//    ) {
//        itemsIndexed(lazyMovieItems) { index, movie ->
//            if (index == 0) {
//                Spacer(modifier = Modifier.padding(4.dp))
//            }
//            MovieCard(
//                index = index,
//                movie = movie,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp)
//                    .clickable { onMovieClick(movie) }
//            )
//        }
//
//        ...
//    }
//}
