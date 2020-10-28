package com.charmist.domain.model

data class Movie(
    val results: List<MovieDetail>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
)