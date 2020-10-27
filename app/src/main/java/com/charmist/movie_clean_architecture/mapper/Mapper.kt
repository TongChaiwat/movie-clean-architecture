package com.charmist.movie_clean_architecture.mapper

interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V

}