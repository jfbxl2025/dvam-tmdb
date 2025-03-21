package eu.epfc.tmdb.network

import eu.epfc.tmdb.network.model.Movie

import eu.epfc.tmdb.network.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("/{version}/movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int,
        @Path("version") version: Int = TmdbService.DEFAULT_VERSION,
        @Query("api_key") apiKey: String =  TmdbService.API_KEY
    ): Response<Movie>
}