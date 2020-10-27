package com.charmist.cache.factory

import com.charmist.data.model.BufferooEntity
import org.buffer.android.boilerplate.cache.model.CachedBufferoo
import com.charmist.cache.factory.DataFactory.Factory.randomUuid

class BufferooFactory {

    companion object Factory {

        fun makeCachedBufferoo(): CachedBufferoo {
            return CachedBufferoo(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferooEntity(): BufferooEntity {
            return BufferooEntity(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferooEntityList(count: Int): List<BufferooEntity> {
            val bufferooEntities = mutableListOf<BufferooEntity>()
            repeat(count) {
                bufferooEntities.add(makeBufferooEntity())
            }
            return bufferooEntities
        }

        fun makeCachedBufferooList(count: Int): List<CachedBufferoo> {
            val cachedBufferoos = mutableListOf<CachedBufferoo>()
            repeat(count) {
                cachedBufferoos.add(makeCachedBufferoo())
            }
            return cachedBufferoos
        }

    }

}