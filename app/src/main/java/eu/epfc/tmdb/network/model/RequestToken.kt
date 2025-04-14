package eu.epfc.tmdb.network.model

import com.google.gson.annotations.SerializedName

data class RequestToken(
    val success: Boolean,
    @SerializedName("expire_at")
    val expiresAt:  String,
    @SerializedName("request_token")
    val requestToken: String
)
