package com.charmist.domain.factory

import com.charmist.domain.factory.DataFactory.Factory.randomUuid
import com.charmist.domain.model.Bufferoo

class BufferooFactory {

    companion object Factory {

        fun makeBufferooList(count: Int): List<Bufferoo> {
            val bufferoos = mutableListOf<Bufferoo>()
            repeat(count) {
                bufferoos.add(makeBufferoo())
            }
            return bufferoos
        }

        fun makeBufferoo(): Bufferoo {
            return Bufferoo(randomUuid(), randomUuid(), randomUuid())
        }

    }

}