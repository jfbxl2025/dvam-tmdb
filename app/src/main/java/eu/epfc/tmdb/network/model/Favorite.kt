package eu.epfc.tmdb.network.model

import com.google.gson.annotations.SerializedName

data class Favorite(
    @SerializedName("media_type")
    val mediaType: String = "movie",
    @SerializedName("media_id")
    val mediaId: Int = 0,
    val favorite: Boolean = false
)
