package eu.epfc.tmdb.network

import eu.epfc.tmdb.network.model.Details
import eu.epfc.tmdb.network.model.Favorite
import eu.epfc.tmdb.network.model.Movie
import eu.epfc.tmdb.network.model.Page
import eu.epfc.tmdb.network.model.Result
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbClient {

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int,
//        @Query("language") language: String =  "fr-FR",
    ): Page<Movie>

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int,
//        @Query("language") language: String =  "fr-FR",
    ): Page<Movie>

    @POST("account/null/favorite")
    suspend fun setFavorite(@Body favorite: Favorite): Result

    @GET("account/null/favorite/movies")
    suspend fun getFavorites(
        @Query("page") page: Int,
    ): Page<Movie>

    @GET("movie/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id") movieId: Int
    ): Details
}