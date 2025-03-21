package eu.epfc.tmdb.network

import eu.epfc.tmdb.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TmdbService {

    const val DEFAULT_VERSION = 3
    const val API_KEY = BuildConfig.TMDB_API_KEY
    private const val baseURL = "https://api.themoviedb.org"

    val moviesClient: MoviesClient
    init {
        val jsonConverter = MoshiConverterFactory.create()
        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(jsonConverter)
                .baseUrl(baseURL)
        val retrofit = retrofitBuilder.build()
        moviesClient = retrofit.create(MoviesClient::class.java)
    }
}