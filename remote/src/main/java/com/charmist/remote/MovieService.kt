package com.charmist.remote

import com.charmist.remote.model.BufferooModel
import com.charmist.remote.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/api/movies/search")
    fun getBufferoos(
        @Query("query") limit: String,
        @Query("page") offset: Int
    ): Single<BufferooResponse>

    class BufferooResponse {
        lateinit var team: List<BufferooModel>
        lateinit var results: MutableList<MovieModel>
        var page: Int = 0
        var total_pages: Int = 0
        var total_results: Int = 0
    }

}
