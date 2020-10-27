package com.charmist.data.mapper

import com.charmist.domain.model.Bufferoo
import com.charmist.data.model.BufferooEntity
import javax.inject.Inject

open class BufferooMapper @Inject constructor() : Mapper<BufferooEntity, Bufferoo> {

    override fun mapFromEntity(type: BufferooEntity): Bufferoo {
        return Bufferoo(type.name, type.title, type.avatar)
    }

    override fun mapToEntity(type: Bufferoo): BufferooEntity {
        return BufferooEntity(type.name, type.title, type.avatar)
    }


}