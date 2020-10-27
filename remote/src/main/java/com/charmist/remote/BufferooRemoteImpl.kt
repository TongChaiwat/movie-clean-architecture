package com.charmist.remote

import com.charmist.data.model.BufferooEntity
import com.charmist.data.repository.BufferooRemote
import com.charmist.remote.mapper.BufferooEntityMapper
import io.reactivex.Single
import javax.inject.Inject

class BufferooRemoteImpl @Inject constructor(
    private val bufferooService: BufferooService,
    private val entityMapper: BufferooEntityMapper
) :
    BufferooRemote {
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooService.getBufferoos()
            .map {
                it.team.map { listItem ->
                    entityMapper.mapFromRemote(listItem)
                }
            }
    }

}