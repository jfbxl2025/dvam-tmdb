package eu.epfc.tmdb.data

import eu.epfc.tmdb.network.TmdbClient
import eu.epfc.tmdb.network.model.Details
import eu.epfc.tmdb.network.model.Favorite

class MovieRepository(private val client: TmdbClient) {

    suspend fun getDetails(movieId: Int) : Details {
        return client.getDetails(movieId)
    }

    suspend fun addToFavorite( movieId: Int) {
        client.setFavorite(Favorite(mediaId = movieId, favorite = true))
    }
    suspend fun removeFavorite( movieId: Int) {
        client.setFavorite(Favorite(mediaId = movieId, favorite = false))
    }



}