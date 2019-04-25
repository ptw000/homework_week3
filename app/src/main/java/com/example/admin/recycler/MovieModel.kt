package com.example.admin.recycler
import java.io.Serializable

class MovieModel :Serializable  {
    var vote_count: String? = null
    var id: Int? = null
    var video: Boolean? = null
    var vote_average: Float? = null
    var title: String? = null
    var popularity: Float? = null
    var poster_path: String? = null
    var original_language: String? = null
    var original_title: String? = null
    var genre_ids: ArrayList<Int>? = null
    var backdrop_path: String? = null
    var adult: Boolean? = null
    var overview: String? = null
    var release_date: String? = null
}

