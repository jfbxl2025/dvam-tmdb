package eu.epfc.tmdb.network.model

import com.squareup.moshi.Json


data class RequestToken(
    val success: Boolean,
    @Json(name = "expire_at")
    val expiresAt:  String,
    @Json(name = "request_token")
    val requestToken: String
)
