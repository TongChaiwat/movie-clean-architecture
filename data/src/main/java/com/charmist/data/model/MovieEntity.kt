package com.charmist.data.model

data class MovieEntity(
    val results: List<MovieDetailEntity>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
)