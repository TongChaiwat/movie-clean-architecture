package com.charmist.remote.model

data class MovieModel(
    val results: MutableList<MovieModel>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
)