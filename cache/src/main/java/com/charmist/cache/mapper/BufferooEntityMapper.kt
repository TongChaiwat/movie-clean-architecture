package com.charmist.cache.mapper

import com.charmist.data.model.BufferooEntity
import org.buffer.android.boilerplate.cache.model.CachedBufferoo
import javax.inject.Inject

class BufferooEntityMapper @Inject constructor() : EntityMapper<CachedBufferoo, BufferooEntity> {

    override fun mapToCached(type: BufferooEntity): CachedBufferoo {
        return CachedBufferoo(type.name, type.title, type.avatar)
    }

    override fun mapFromCached(type: CachedBufferoo): BufferooEntity {
        return BufferooEntity(type.name, type.title, type.avatar)
    }

}