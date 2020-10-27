package com.charmist.data

import com.charmist.data.mapper.BufferooMapper
import com.charmist.data.model.BufferooEntity
import com.charmist.domain.model.Bufferoo
import com.charmist.domain.repository.BufferooRepository
import io.reactivex.Completable
import io.reactivex.Single
import com.charmist.data.source.BufferooDataStoreFactory
import com.charmist.data.source.BufferooRemoteDataStore
import javax.inject.Inject

class BufferooDataRepository @Inject constructor(
    private val factory: BufferooDataStoreFactory,
    private val bufferooMapper: BufferooMapper
) :
    BufferooRepository {

    override fun clearBufferoos(): Completable {
        return factory.retrieveCacheDataStore().clearBufferoos()
    }

    override fun saveBufferoos(bufferoos: List<Bufferoo>): Completable {
        val bufferooEntities = bufferoos.map { bufferooMapper.mapToEntity(it) }
        return saveBufferooEntities(bufferooEntities)
    }

    private fun saveBufferooEntities(bufferoos: List<BufferooEntity>): Completable {
        return factory.retrieveCacheDataStore().saveBufferoos(bufferoos)
    }

    override fun getBufferoos(): Single<List<Bufferoo>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getBufferoos()
            .flatMap {
                if (dataStore is BufferooRemoteDataStore) {
                    saveBufferooEntities(it).toSingle { it }
                } else {
                    Single.just(it)
                }
            }
            .map { list ->
                list.map { listItem ->
                    bufferooMapper.mapFromEntity(listItem)
                }
            }
    }

}