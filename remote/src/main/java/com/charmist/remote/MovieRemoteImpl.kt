package com.charmist.remote

import com.charmist.data.model.BufferooEntity
import com.charmist.data.repository.BufferooRemote
import com.charmist.remote.mapper.MovieEntityMapper
import io.reactivex.Single
import javax.inject.Inject

class MovieRemoteImpl @Inject constructor(
    private val movieService: MovieService,
    private val entityMapper: MovieEntityMapper
) :
    BufferooRemote {
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return movieService.getMovies("man",1)
            .map {
                var b = it.results
                it.team.map { listItem ->
                    entityMapper.mapFromRemote(listItem)
                }
            }
    }

}