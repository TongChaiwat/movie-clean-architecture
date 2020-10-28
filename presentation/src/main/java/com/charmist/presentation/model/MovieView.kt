package com.charmist.presentation.model

data class MovieView(
    val results: MutableList<MovieDetailView>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
)