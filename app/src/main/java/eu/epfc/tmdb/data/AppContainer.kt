package eu.epfc.tmdb.data

import eu.epfc.tmdb.network.TmdbService

interface AppContainer {
    val moviesRepository: MoviesRepository
    val movieRepository: MovieRepository
    val favoritesRepository: FavoritesRepository
}

object DefaultAppContainer : AppContainer {

    override val moviesRepository: MoviesRepository by lazy {
        MoviesRepository(TmdbService.tmdbClient)
    }
    override val movieRepository: MovieRepository by lazy {
        MovieRepository(TmdbService.tmdbClient)
    }
    override val favoritesRepository: FavoritesRepository by lazy {
        FavoritesRepository(TmdbService.tmdbClient)
    }


}