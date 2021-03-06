package com.charmist.remote.factory

import com.charmist.remote.MovieService
import com.charmist.remote.factory.DataFactory.Factory.randomUuid
import com.charmist.remote.model.BufferooModel


class BufferooFactory {

    companion object Factory {

        fun makeBufferooResponse(): MovieService.BufferooResponse {
            val bufferooResponse = MovieService.BufferooResponse()
            bufferooResponse.team = makeBufferooModelList(5)
            return bufferooResponse
        }

        fun makeBufferooModelList(count: Int): List<BufferooModel> {
            val bufferooEntities = mutableListOf<BufferooModel>()
            repeat(count) {
                bufferooEntities.add(makeBufferooModel())
            }
            return bufferooEntities
        }

        fun makeBufferooModel(): BufferooModel {
            return BufferooModel(randomUuid(), randomUuid(), randomUuid())
        }

    }

}