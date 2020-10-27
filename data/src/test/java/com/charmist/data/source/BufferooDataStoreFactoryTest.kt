package com.charmist.data.source

import com.charmist.data.repository.BufferooCache
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BufferooDataStoreFactoryTest {

    private lateinit var bufferooDataStoreFactory: BufferooDataStoreFactory

    private lateinit var bufferooCache: BufferooCache
    private lateinit var bufferooCacheDataStore: BufferooCacheDataStore
    private lateinit var bufferooRemoteDataStore: BufferooRemoteDataStore

    @Before
    fun setUp() {
        bufferooCache = mock()
        bufferooCacheDataStore = mock()
        bufferooRemoteDataStore = mock()
        bufferooDataStoreFactory = BufferooDataStoreFactory(bufferooCache,
                bufferooCacheDataStore, bufferooRemoteDataStore)
    }

    //<editor-fold desc="Retrieve Data Store">
    @Test
    fun retrieveDataStoreWhenNotCachedReturnsRemoteDataStore() {
        stubBufferooCacheIsCached(false)
        val bufferooDataStore = bufferooDataStoreFactory.retrieveDataStore()
        assert(bufferooDataStore is BufferooRemoteDataStore)
    }

    @Test
    fun retrieveDataStoreWhenCacheExpiredReturnsRemoteDataStore() {
        stubBufferooCacheIsCached(true)
        stubBufferooCacheIsExpired(true)
        val bufferooDataStore = bufferooDataStoreFactory.retrieveDataStore()
        assert(bufferooDataStore is BufferooRemoteDataStore)
    }

    @Test
    fun retrieveDataStoreReturnsCacheDataStore() {
        stubBufferooCacheIsCached(true)
        stubBufferooCacheIsExpired(false)
        val bufferooDataStore = bufferooDataStoreFactory.retrieveDataStore()
        assert(bufferooDataStore is BufferooCacheDataStore)
    }

    @Test
    fun retrieveRemoteDataStoreReturnsRemoteDataStore() {
        val bufferooDataStore = bufferooDataStoreFactory.retrieveRemoteDataStore()
        assert(bufferooDataStore is BufferooRemoteDataStore)
    }

    @Test
    fun retrieveCacheDataStoreReturnsCacheDataStore() {
        val bufferooDataStore = bufferooDataStoreFactory.retrieveCacheDataStore()
        assert(bufferooDataStore is BufferooCacheDataStore)
    }

    private fun stubBufferooCacheIsCached(isCached: Boolean) {
        whenever(bufferooCache.isCached())
                .thenReturn(isCached)
    }

    private fun stubBufferooCacheIsExpired(isExpired: Boolean) {
        whenever(bufferooCache.isExpired())
                .thenReturn(isExpired)
    }

}