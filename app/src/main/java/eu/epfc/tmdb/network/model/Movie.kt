package eu.epfc.tmdb.network.model

import com.squareup.moshi.Json

private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185"

data class Movie(
   @Json(name = "adult")
    val adult: Boolean = false,
   @Json(name = "backdrop_path")
    val backdropPath: String?,
   @Json(name = "genre_ids")
    val genreIds: List<Int> = emptyList(),
   @Json(name = "id")
    val id: Int = 0,
   @Json(name = "original_language")
    val originalLanguage: String = "",
   @Json(name = "original_title")
    val originalTitle: String = "",
   @Json(name = "overview")
    val overview: String = "",
   @Json(name = "popularity")
    val popularity: Double = 0.0,
   @Json(name = "poster_path")
    val posterPath: String?,
   @Json(name = "release_date")
    val releaseDate: String = "",
   @Json(name = "title")
    val title: String = "",
   @Json(name = "video")
    val video: Boolean = false,
   @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
   @Json(name = "vote_count")
    val voteCount: Int = 0
){
    val poster: String
        get() = "$BASE_IMAGE_URL${posterPath}"
}
