package com.charmist.remote.mapper

import com.charmist.data.model.BufferooEntity
import com.charmist.remote.model.BufferooModel
import javax.inject.Inject

open class MovieEntityMapper @Inject constructor() :
    EntityMapper<BufferooModel, BufferooEntity> {

    override fun mapFromRemote(type: BufferooModel): BufferooEntity {
        return BufferooEntity(type.name, type.title, type.avatar)
    }

}