package eu.epfc.tmdb.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import eu.epfc.tmdb.data.MoviesRepository.Companion.NETWORK_PAGE_SIZE
import eu.epfc.tmdb.data.MoviesRepository.Companion.STARTING_PAGE_INDEX
import eu.epfc.tmdb.network.MoviesClient
import eu.epfc.tmdb.network.model.Movie


class MoviesPagingSource( private val client: MoviesClient): PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,Movie> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = client.getPopular(page=position)
            val movies = response.results
            val nextKey = if (movies.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                if (position > 20) {
                    null
                } else {
                    Log.i("***PagingSource. load", "$position  -  ${params.loadSize} ")
                    position + (params.loadSize / NETWORK_PAGE_SIZE)
                }

            }
//            Log.i("length***", movies.count().toString())
            LoadResult.Page(
                data = movies,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch(e: Exception) {
            LoadResult.Error(e)
        }

    }
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}