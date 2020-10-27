package com.charmist.presentation.mapper

import com.charmist.domain.model.Bufferoo
import com.charmist.presentation.model.BufferooView
import javax.inject.Inject

open class BufferooMapper @Inject constructor() : Mapper<BufferooView, Bufferoo> {

    override fun mapToView(type: Bufferoo): BufferooView {
        return BufferooView(type.name, type.title, type.avatar)
    }

}