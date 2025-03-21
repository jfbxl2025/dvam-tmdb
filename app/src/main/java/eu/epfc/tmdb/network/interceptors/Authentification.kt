package eu.epfc.tmdb.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class Authentification(private val apiKey: String): Interceptor {

    companion object {
        private const val PARAM_API_KEY = "api_key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
       val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(PARAM_API_KEY, apiKey)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .build()

        return  chain.proceed(newRequest)
    }
}