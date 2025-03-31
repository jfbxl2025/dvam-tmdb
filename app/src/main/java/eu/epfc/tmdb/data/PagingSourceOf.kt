package eu.epfc.tmdb.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import eu.epfc.tmdb.network.model.Page


class PagingSourceOf<T: Any>(
    private val startingPageIndex: Int = 1,
    private val networkPageSize: Int,
    private val loadAction: suspend (Int) -> Page<T>
): PagingSource<Int, T>() {
//
//    init {
//        Log.i("Paging source ***","On init ****")
//    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val position = params.key ?: startingPageIndex
//        Log.i("Paging source ***", "on load ${position.toString()}")
        return try {
            val page = loadAction(position)
//            Log.i("Paging source ***", "on result: ${page.toString()}")
            val nextKey = if (page.results.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                    position + (params.loadSize / networkPageSize)
            }
            LoadResult.Page(
                data = page.results,
                prevKey = if (position == startingPageIndex) null else position - 1,
                nextKey = nextKey
            )
        } catch(e: Exception) {
            Log.e("Paging source ***", e.message ?: "on error")
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        Log.i("getRefreshKey***", state.anchorPosition.toString())
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}