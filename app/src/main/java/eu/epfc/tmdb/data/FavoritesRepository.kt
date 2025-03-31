package eu.epfc.tmdb.data

import eu.epfc.tmdb.network.TmdbClient
import eu.epfc.tmdb.network.model.Details
import eu.epfc.tmdb.network.model.Movie

class FavoritesRepository(private val client: TmdbClient) {
    suspend fun getIds() : List<Int> {
        val ids: MutableList<Int> = listOf<Int>().toMutableList()
        val firstPage = client.getFavorites(1)
        firstPage.results.forEach { ids.add(it.id) }
        for (i in 2..firstPage.totalPages ) {
            client.getFavorites(page = i).results.forEach { ids.add(it.id) }
        }

        return ids
    }
}