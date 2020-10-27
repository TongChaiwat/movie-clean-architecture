package com.charmist.data.source

import com.charmist.data.factory.BufferooFactory
import com.charmist.data.model.BufferooEntity
import com.charmist.data.repository.BufferooRemote
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BufferooRemoteDataStoreTest {

    private lateinit var bufferooRemoteDataStore: BufferooRemoteDataStore

    private lateinit var bufferooRemote: BufferooRemote

    @Before
    fun setUp() {
        bufferooRemote = mock()
        bufferooRemoteDataStore = BufferooRemoteDataStore(bufferooRemote)
    }


    @Test(expected = UnsupportedOperationException::class)
    fun clearBufferoosThrowsException() {
        bufferooRemoteDataStore.clearBufferoos().test()
    }


    @Test(expected = UnsupportedOperationException::class)
    fun saveBufferoosThrowsException() {
        bufferooRemoteDataStore.saveBufferoos(BufferooFactory.makeBufferooEntityList(2)).test()
    }


    @Test
    fun getBufferoosCompletes() {
        stubBufferooCacheGetBufferoos(Single.just(BufferooFactory.makeBufferooEntityList(2)))
        val testObserver = bufferooRemote.getBufferoos().test()
        testObserver.assertComplete()
    }


    private fun stubBufferooCacheGetBufferoos(single: Single<List<BufferooEntity>>) {
        whenever(bufferooRemote.getBufferoos())
            .thenReturn(single)
    }


}