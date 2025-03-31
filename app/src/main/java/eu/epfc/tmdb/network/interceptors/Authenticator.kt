package eu.epfc.tmdb.network.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class Authenticator(private val apiKey: String, private val accessToken: String): Interceptor {

    companion object {
        private const val PARAM_API_KEY = "api_key"
        const val HEADER_AUTHORIZATION = "Authorization"
        const val TOKEN_TYPE = "Bearer"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
//        Log.i("auth ****", apiKey)
       val request = chain.request()
//        val url = request.url.newBuilder()
//            .addQueryParameter(PARAM_API_KEY, apiKey)
//            .build()

        val newRequest = request.newBuilder()
            .addHeader(HEADER_AUTHORIZATION, "$TOKEN_TYPE $accessToken")
//            .url(url)
            .build()

        return  chain.proceed(newRequest)
    }
}