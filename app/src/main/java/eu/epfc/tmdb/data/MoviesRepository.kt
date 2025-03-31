package eu.epfc.tmdb.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import eu.epfc.tmdb.network.TmdbClient
import eu.epfc.tmdb.network.model.Movie
import kotlinx.coroutines.flow.Flow

class MoviesRepository(private val client: TmdbClient) {


    fun getPopular() = getMoviesStream { PagingSourceOf<Movie>(1,20) {page -> client.getPopular(page=page)}}
    fun getTopRated() = getMoviesStream { PagingSourceOf<Movie>(1,20) {page -> client.getTopRated(page=page)}}
    fun getFavorites() = getMoviesStream { PagingSourceOf<Movie>(1,20) {page -> client.getFavorites(page=page)}}

    private fun getMoviesStream(pagingSourceFactory: () -> PagingSource<Int, Movie>): Flow<PagingData<Movie>> {
        return Pager(
            initialKey = STARTING_PAGE_INDEX,
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = pagingSourceFactory
//            pagingSourceFactory = { MoviesPagingSource(client)}
        ).flow
    }

    companion object {

        const val STARTING_PAGE_INDEX = 1
        const val NETWORK_PAGE_SIZE = 20
    }

}