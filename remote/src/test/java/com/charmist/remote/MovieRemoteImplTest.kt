package com.charmist.remote

import com.charmist.data.model.BufferooEntity
import com.charmist.remote.factory.BufferooFactory
import com.charmist.remote.mapper.MovieEntityMapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieRemoteImplTest {

    private lateinit var entityMapper: MovieEntityMapper
    private lateinit var movieService: MovieService

    private lateinit var movieRemoteImpl: MovieRemoteImpl

    @Before
    fun setup() {
        entityMapper = mock()
        movieService = mock()
        movieRemoteImpl = MovieRemoteImpl(movieService, entityMapper)
    }

    //<editor-fold desc="Get Bufferoos">
    @Test
    fun getBufferoosCompletes() {
        stubBufferooServiceGetBufferoos(Single.just(BufferooFactory.makeBufferooResponse()))
        val testObserver = movieRemoteImpl.getBufferoos().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBufferoosReturnsData() {
        val bufferooResponse = BufferooFactory.makeBufferooResponse()
        stubBufferooServiceGetBufferoos(Single.just(bufferooResponse))
        val bufferooEntities = mutableListOf<BufferooEntity>()
        bufferooResponse.team.forEach {
            bufferooEntities.add(entityMapper.mapFromRemote(it))
        }

        val testObserver = movieRemoteImpl.getBufferoos().test()
        testObserver.assertValue(bufferooEntities)
    }
    //</editor-fold>

    private fun stubBufferooServiceGetBufferoos(single: Single<MovieService.BufferooResponse>) {
        whenever(movieService.getMovies("man",1))
            .thenReturn(single)
    }
}