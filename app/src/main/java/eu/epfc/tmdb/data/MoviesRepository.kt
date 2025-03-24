package eu.epfc.tmdb.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import eu.epfc.tmdb.network.MoviesClient
import eu.epfc.tmdb.network.model.Movie
import eu.epfc.tmdb.network.model.Response
import kotlinx.coroutines.flow.Flow

class MoviesRepository(private val client: MoviesClient) {

    fun getMoviesStream(): Flow<PagingData<Movie>> {

//        suspend fun callClient(page:Int): Response<Movie> {
//            return client.getPopular(page=page)
//        }

        return Pager(
            initialKey = STARTING_PAGE_INDEX,
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { MoviesPagingSource(client)}
//            pagingSourceFactory = { PagingSourceResponseOf<Movie>(1,20) {page -> client.getPopular(page=page)}}
        ).flow
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
        const val NETWORK_PAGE_SIZE = 20
    }

}