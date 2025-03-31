package eu.epfc.tmdb.network.model

import com.google.gson.annotations.SerializedName

data class Genre(
    val id: Int = 0,
    val name: String = "",
)

data class Country(
    @SerializedName("iso_3166_1") val iso3166: String,
    val name: String
)

data class Company(
    @SerializedName("id")  val id: Int,
    @SerializedName("logo_path") val logoPath: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("origin_country") val originCountry: String = ""
)

data class Language(
    @SerializedName("english_name")  val englishName: String = "",
    @SerializedName("iso_639_1") val iso639: String = "",
    @SerializedName("name") val name: String = "",
)




data class Details(
    @SerializedName("adult") val adult: Boolean = false,
    @SerializedName("backdrop_path") val backdropPath: String = "",
    @SerializedName("budget") val budget: Long = 0,
    @SerializedName("genres") val genres: List<Genre> = emptyList(),
    @SerializedName("homepage") val homepage: String? = null,
    @SerializedName("id")val id: Int = 0,
    @SerializedName("imdb_id") val imdbId: String? = null,
    @SerializedName("original_language") val originalLanguage: String = "",
    @SerializedName("original_title") val originalTitle: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("popularity") val popularity: Float = 0.0F,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("production_companies") val productionCompanies: List<Company>? = null,
    @SerializedName("production_countries") val productionCountries: List<Country>? = null,
    @SerializedName("release_date")val releaseDate: String = "",
    @SerializedName("revenue") val revenue: Long = 0,
    @SerializedName("runtime") val runtime: Int? = null,
    @SerializedName("spoken_languages") val spokenLanguages: List<Language> = emptyList(),
    @SerializedName("status") val status: String = "",
    @SerializedName("tagline") val tagline: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Float = 0.0F,
    @SerializedName("vote_count") val voteCount: Int = 0,

)
