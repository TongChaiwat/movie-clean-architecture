package com.charmist.data.source

import com.charmist.data.model.BufferooEntity
import io.reactivex.Completable
import io.reactivex.Single
import com.charmist.data.repository.BufferooDataStore
import com.charmist.data.repository.BufferooRemote
import javax.inject.Inject

open class BufferooRemoteDataStore @Inject constructor(private val bufferooRemote: BufferooRemote) :
    BufferooDataStore {

    override fun clearBufferoos(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooRemote.getBufferoos()
    }

}