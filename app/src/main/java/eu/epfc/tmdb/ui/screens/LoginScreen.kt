package eu.epfc.tmdb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import eu.epfc.tmdb.ui.TmdbViewModelProvider
import eu.epfc.tmdb.ui.components.MovieCard
import eu.epfc.tmdb.ui.components.TmdbScaffold

@Composable
fun LoginScreen(
    navigateToMovieDetail: (Pair<Int, Boolean>) -> Unit,
    loginViewModel: LoginViewModel = viewModel(factory = TmdbViewModelProvider.Factory),
    modifier: Modifier = Modifier
) {

    TmdbScaffold(
        title = "Login screen"
    ) {
            Column {
               Row {
                   Text(text="User name")
               }
                Row {
                    Text(text="password")
                }
                Button(onClick = { loginViewModel.login()}) {
                   Text(text = "Login")
               }
            }

    }


}
