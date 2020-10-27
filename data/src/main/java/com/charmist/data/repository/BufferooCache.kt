package com.charmist.data.repository

import com.charmist.data.model.BufferooEntity
import io.reactivex.Completable
import io.reactivex.Single

interface BufferooCache {

    fun clearBufferoos(): Completable

    fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable

    fun getBufferoos(): Single<List<BufferooEntity>>

    fun isCached(): Boolean

    fun setLastCacheTime(lastCache: Long)

    fun isExpired(): Boolean

}