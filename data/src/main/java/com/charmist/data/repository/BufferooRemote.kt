package com.charmist.data.repository

import com.charmist.data.model.BufferooEntity
import io.reactivex.Single

interface BufferooRemote {

    fun getBufferoos(): Single<List<BufferooEntity>>

}