package com.charmist.data.source

import com.charmist.data.model.BufferooEntity
import io.reactivex.Completable
import io.reactivex.Single
import com.charmist.data.repository.BufferooCache
import com.charmist.data.repository.BufferooDataStore
import javax.inject.Inject

open class BufferooCacheDataStore @Inject constructor(private val bufferooCache: BufferooCache) :
    BufferooDataStore {

    override fun clearBufferoos(): Completable {
        return bufferooCache.clearBufferoos()
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        return bufferooCache.saveBufferoos(bufferoos)
            .doOnComplete {
                bufferooCache.setLastCacheTime(System.currentTimeMillis())
            }
    }

    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooCache.getBufferoos()
    }

}