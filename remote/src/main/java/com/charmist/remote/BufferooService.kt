package com.charmist.remote

import com.charmist.remote.model.BufferooModel
import io.reactivex.Single
import retrofit2.http.GET

interface BufferooService {

    @GET("team.json")
    fun getBufferoos(): Single<BufferooResponse>

    class BufferooResponse {
        lateinit var team: List<BufferooModel>
    }

}
