package com.charmist.remote.model

data class MovieModel(
    val results: MutableList<MovieDetailModel>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
)