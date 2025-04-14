package eu.epfc.tmdb.network

import eu.epfc.tmdb.BuildConfig
import eu.epfc.tmdb.network.interceptors.ApiKeyInterceptor
import eu.epfc.tmdb.network.interceptors.TokenAuthenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object TmdbService {

    const val DEFAULT_VERSION = 3
    private const val API_KEY = BuildConfig.TMDB_API_KEY
    private const val ACCESS_TOKEN = BuildConfig.TMDB_ACCESS_TOKEN
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val tmdbClient: TmdbClient

    init {
        val logger = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
//        val tokenAuthenticator = TokenAuthenticator( accessToken = ACCESS_TOKEN)
        val apiKeyInterceptor = ApiKeyInterceptor(API_KEY)
        val client = OkHttpClient.Builder()
//            .authenticator(tokenAuthenticator)
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(logger)

            .build()
//        val jsonConverter = MoshiConverterFactory.create()
        val jsonConverter = GsonConverterFactory.create()

        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(jsonConverter)
                .baseUrl(BASE_URL)
                .client(client)
        val retrofit = retrofitBuilder.build()
        tmdbClient = retrofit.create(TmdbClient::class.java)

    }
}