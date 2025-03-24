package eu.epfc.tmdb.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import eu.epfc.tmdb.network.model.Movie
import eu.epfc.tmdb.network.model.Response
import kotlin.reflect.KSuspendFunction3


class PagingSourceResponseOf<T: Any>(
    private val startingPageIndex: Int = 1,
    private val networkPageSize: Int,
    private val loadAction: suspend (Int) -> Response<T>
): PagingSource<Int, T>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val position = params.key ?: startingPageIndex
        return try {
            val results = loadAction(position).results
            val nextKey = if (results.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                    position + (params.loadSize / networkPageSize)
            }
            LoadResult.Page(
                data = results,
                prevKey = if (position == startingPageIndex) null else position - 1,
                nextKey = nextKey
            )
        } catch(e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}