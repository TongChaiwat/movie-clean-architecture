package com.charmist.domain.interactor.browse

import io.reactivex.Single
import com.charmist.domain.executor.PostExecutionThread
import com.charmist.domain.executor.ThreadExecutor
import com.charmist.domain.interactor.SingleUseCase
import com.charmist.domain.model.Bufferoo
import com.charmist.domain.repository.BufferooRepository
import javax.inject.Inject

open class GetBufferoos @Inject constructor(val bufferooRepository: BufferooRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread
):
        SingleUseCase<List<Bufferoo>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Bufferoo>> {
        return bufferooRepository.getBufferoos()
    }

}