package eu.epfc.tmdb.network

import android.util.Log
import eu.epfc.tmdb.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object TmdbService {

    const val DEFAULT_VERSION = 3
    const val API_KEY = BuildConfig.TMDB_API_KEY
    private const val baseURL = "https://api.themoviedb.org/3/"

    val moviesClient: MoviesClient
    init {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val jsonConverter = MoshiConverterFactory.create()
//        val gsonConverter = GsonConverterFactory.create()
        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(jsonConverter)
                .baseUrl(baseURL)
                .client(client)
        val retrofit = retrofitBuilder.build()
        moviesClient = retrofit.create(MoviesClient::class.java)

    }
}