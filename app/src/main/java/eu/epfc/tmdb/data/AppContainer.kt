package eu.epfc.tmdb.data

import eu.epfc.tmdb.BuildConfig
import eu.epfc.tmdb.network.MoviesClient
import eu.epfc.tmdb.network.MoviesService
import eu.epfc.tmdb.network.TmdbService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface AppContainer {
    val moviesRepository: MoviesRepository
}

object DefaultAppContainer : AppContainer {

    override val moviesRepository: MoviesRepository by lazy {
        MoviesRepository(TmdbService.moviesClient)
    }

}