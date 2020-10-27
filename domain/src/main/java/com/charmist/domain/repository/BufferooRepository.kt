package com.charmist.domain.repository

import com.charmist.domain.model.Bufferoo
import io.reactivex.Completable
import io.reactivex.Single

interface BufferooRepository {

    fun clearBufferoos(): Completable

    fun saveBufferoos(bufferoos: List<Bufferoo>): Completable

    fun getBufferoos(): Single<List<Bufferoo>>

}