package com.charmist.data.source

import com.charmist.data.repository.BufferooCache
import com.charmist.data.repository.BufferooDataStore
import javax.inject.Inject

open class BufferooDataStoreFactory @Inject constructor(
    private val bufferooCache: BufferooCache,
    private val bufferooCacheDataStore: BufferooCacheDataStore,
    private val bufferooRemoteDataStore: BufferooRemoteDataStore
) {

    open fun retrieveDataStore(): BufferooDataStore {
        if (bufferooCache.isCached() && !bufferooCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    open fun retrieveCacheDataStore(): BufferooDataStore {
        return bufferooCacheDataStore
    }

    open fun retrieveRemoteDataStore(): BufferooDataStore {
        return bufferooRemoteDataStore
    }

}