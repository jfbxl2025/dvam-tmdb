package eu.epfc.tmdb.network.model

import com.google.gson.annotations.SerializedName


//import com.squareup.moshi.Json

data class Page<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int

//    @SerializedName("page")
//    val page: Int,
//    @SerializedName("results")
//    val results: List<T>,
//    @SerializedName("total_pages") val totalPages: Int,
//    @SerializedName("total_results") val totalResults: Int
)